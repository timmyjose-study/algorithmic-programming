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

int min_diff(const vector<int> &a, int sum1, int total, vector<vector<int>> &dp,
             int curr_idx) {
  if (curr_idx == a.size()) {
    int sum2 = total - sum1;
    return abs(sum1 - sum2);
  }

  if (dp[curr_idx][sum1] == -1) {
    dp[curr_idx][sum1] =
        min_diff(a, sum1 + a[curr_idx], total, dp, curr_idx + 1);

    dp[curr_idx][sum1] =
        min(dp[curr_idx][sum1], min_diff(a, sum1, total, dp, curr_idx + 1));
  }

  return dp[curr_idx][sum1];
}

// O(ns) / O(ns)
int min_diff(const vector<int> &a) {
  int sum = 0;
  for (int e : a) {
    sum += e;
  }

  vector<vector<int>> dp(a.size(), vector<int>(sum + 1, -1));

  return min_diff(a, 0, sum, dp, 0);
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

    cout << min_diff(a) << "\n";
  }

  return 0;
}