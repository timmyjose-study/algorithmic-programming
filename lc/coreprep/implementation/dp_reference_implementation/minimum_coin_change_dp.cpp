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

// O(na) / O(na)
int min_change(int amount, const vector<int> &coins) {
  if (amount == 0 || coins.empty()) {
    return -1;
  }

  vector<vector<int>> dp(coins.size(), vector<int>(amount + 1, 0));

  for (int i = 0; i < coins.size(); i++) {
    dp[i][0] = 0;
  }

  for (int i = 0; i < coins.size(); i++) {
    for (int a = 1; a <= amount; a++) {
      int ways1 = numeric_limits<int>::max();

      if (coins[i] <= a) {
        int res = dp[i][a - coins[i]];

        if (res != numeric_limits<int>::max()) {
          ways1 = 1 + res;
        }
      }

      dp[i][a] = ways1;

      if (i > 0) {
        dp[i][a] = min(dp[i][a], dp[i - 1][a]);
      }
    }
  }

  int res = dp[coins.size() - 1][amount];

  return (res == numeric_limits<int>::max() ? -1 : res);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, amount;
  cin >> tt;

  while (tt--) {
    cin >> n >> amount;

    vector<int> coins(n);
    for (int i = 0; i < n; i++) {
      cin >> coins[i];
    }

    cout << min_change(amount, coins) << "\n";
  }

  return 0;
}