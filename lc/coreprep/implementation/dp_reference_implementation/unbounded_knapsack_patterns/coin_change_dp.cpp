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

// o(na) / O(na)
int num_ways(int amount, const vector<int> &coins) {
  if (amount == 0 || coins.empty()) {
    return 1;
  }

  vector<vector<int>> dp(coins.size(), vector<int>(amount + 1, 0));

  for (int i = 0; i < coins.size(); i++) {
    dp[i][0] = 1;
  }

  for (int i = 0; i < coins.size(); i++) {
    for (int a = 1; a <= amount; a++) {
      int ways1 = 0;

      if (coins[i] <= a) {
        ways1 = dp[i][a - coins[i]];
      }

      int ways2 = 0;
      if (i > 0) {
        ways2 = dp[i - 1][a];
      }

      dp[i][a] = ways1 + ways2;
    }
  }

  return dp[coins.size() - 1][amount];
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

    cout << num_ways(amount, coins) << "\n";
  }

  return 0;
}