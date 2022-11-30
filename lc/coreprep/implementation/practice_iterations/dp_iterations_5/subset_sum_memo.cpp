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

bool has_subset(const vector<int> &a, int sum, vector<vector<int>> &dp,
                int curr_idx) {
  if (sum == 0) {
    return true;
  }

  if (curr_idx >= a.size()) {
    return false;
  }

  if (dp[curr_idx][sum] == -1) {
    bool has1 = false;

    if (a[curr_idx] <= sum) {
      has1 = has_subset(a, sum - a[curr_idx], dp, curr_idx + 1);
    }

    dp[curr_idx][sum] = has1 || has_subset(a, sum, dp, curr_idx + 1);
  }

  return dp[curr_idx][sum];
}

// O(ns) / O(ns)
bool has_subset(const vector<int> &a, int sum) {
  if (a.size() == 0) {
    return false;
  }

  vector<vector<int>> dp(a.size(), vector<int>(sum + 1, -1));
  return has_subset(a, sum, dp, 0);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, sum;
  cin >> tt;

  while (tt--) {
    cin >> n >> sum;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << (has_subset(a, sum) ? "true" : "false") << "\n";
  }

  return 0;
}