#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
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
int maximum_sum_subarray_of_size_k(const vector<int> &a, int k) {
  int n = a.size();
  int max_sum = numeric_limits<int>::min();
  int window_start = 0, sum = 0;

  for (int window_end = 0; window_end < n; window_end++) {
    sum += a[window_end];

    if (window_end >= k - 1) {
      max_sum = max(max_sum, sum);
      sum -= a[window_start];
      window_start++;
    }
  }

  return max_sum;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << maximum_sum_subarray_of_size_k(a, k) << "\n";
  }

  return 0;
}