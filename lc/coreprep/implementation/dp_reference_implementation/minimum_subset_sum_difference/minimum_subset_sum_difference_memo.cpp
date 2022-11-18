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

int min_subset_diff(const vector<int> &a, int s1, int s2, int curr_idx,
                    vector<vector<int>> &dp) {
  if (curr_idx == a.size()) {
    return abs(s1 - s2);
  }

  if (dp[curr_idx][s1] != -1) {
    return dp[curr_idx][s1];
  }

  int diff1 = min_subset_diff(a, s1 + a[curr_idx], s2, curr_idx + 1, dp);
  int diff2 = min_subset_diff(a, s1, s2 + a[curr_idx], curr_idx + 1, dp);

  dp[curr_idx][s1] = min(diff1, diff2);

  return dp[curr_idx][s1];
}

// O(ns) / O(ns)
int min_subset_diff(const vector<int> &a) {
  int sum = 0;
  for (int e : a) {
    sum += e;
  }

  vector<vector<int>> dp(a.size(), vector<int>(sum + 1, -1));

  return min_subset_diff(a, 0, 0, 0, dp);
}

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

    cout << min_subset_diff(a) << "\n";
  }

  return 0;
}