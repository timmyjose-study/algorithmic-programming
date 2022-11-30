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

// O(ns) / O(ns)
int count_subsets(const vector<int> &a, int sum) {
  if (a.empty()) {
    return 0;
  }

  vector<vector<int>> dp(a.size(), vector<int>(sum + 1, 0));

  for (int i = 0; i < a.size(); i++) {
    dp[i][0] = 1;
  }

  for (int s = 0; s <= sum; s++) {
    if (a[0] == s) {
      dp[0][s] = 1;
      break;
    }
  }

  for (int i = 1; i < a.size(); i++) {
    for (int s = 1; s <= sum; s++) {
      dp[i][s] = dp[i - 1][s];

      if (a[i] <= s) {
        dp[i][s] += dp[i - 1][s - a[i]];
      }
    }
  }

  return dp[a.size() - 1][sum];
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

    cout << count_subsets(a, sum) << "\n";
  }

  return 0;
}