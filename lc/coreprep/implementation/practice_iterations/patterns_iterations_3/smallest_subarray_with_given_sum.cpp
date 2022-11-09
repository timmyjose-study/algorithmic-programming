#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

// O(n) / O(1)
int smallest_length_subarray_with_given_sum(const vector<int> &a, int s) {
  int n = a.size();
  int min_len = numeric_limits<int>::max();
  int window_start = 0, sum = 0;

  for (int window_end = 0; window_end < n; window_end++) {
    sum += a[window_end];

    while (sum >= s) {
      min_len = min(min_len, window_end - window_start + 1);
      sum -= a[window_start];
      window_start++;
    }
  }

  return min_len == numeric_limits<int>::max() ? 0 : min_len;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, s;
  cin >> tt;

  while (tt--) {
    cin >> n >> s;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << smallest_length_subarray_with_given_sum(a, s) << "\n";
  }

  return 0;
}