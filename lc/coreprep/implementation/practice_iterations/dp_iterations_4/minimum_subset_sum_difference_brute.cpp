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

int min_diff(const vector<int> &a, int sum1, int sum2, int curr_idx) {
  if (curr_idx == a.size()) {
    return abs(sum1 - sum2);
  }

  int diff1 = numeric_limits<int>::max();

  if (a[curr_idx] <= sum) {
    diff1 = min_diff(a, sum1 + a[curr_idx], sum2, curr_idx + 1);
  }
  int diff2 = min_diff(a, sum1, sum2 + a[curr_idx], curr_idx + 1);

  return min(diff1, diff2);
}

// O(2n) / O(n)
int min_diff(const vector<int> &a) { return min_diff(a, 0, 0, 0); }

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << min_diff(a) << "\n";
  }

  return 0;
}