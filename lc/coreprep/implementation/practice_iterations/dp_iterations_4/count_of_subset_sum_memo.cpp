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

int count_subsets(const vector<int> &a, int sum, vector<vector<int>> &dp,
                  int curr_idx) {
  if (sum == 0) {
    return 1;
  }

  if (curr_idx >= a.size()) {
    return 0;
  }

  if (dp[curr_idx][sum] == -1) {
    if (a[curr_idx] <= sum) {
      dp[curr_idx][sum] = count_subsets(a, sum - a[curr_idx], dp, curr_idx + 1);
    } else {
      dp[curr_idx][sum] = 0;
    }

    dp[curr_idx][sum] += count_subsets(a, sum, dp, curr_idx + 1);
  }

  return dp[curr_idx][sum];
}

// O(ns) / O(ns)
int count_subsets(const vector<int> &a, int sum) {
  vector<vector<int>> dp(a.size(), vector<int>(sum + 1, -1));
  return count_subsets(a, sum, dp, 0);
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

    cout << count_subsets(a, s) << "\n";
  }

  return 0;
}