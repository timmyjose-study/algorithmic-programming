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

int num_ways(int amount, const vector<int> &coins, vector<vector<int>> &dp,
             int curr_idx) {

  if (amount == 0) {
    return 1;
  }

  if (curr_idx >= coins.size()) {
    return 0;
  }

  if (dp[curr_idx][amount] == -1) {
    int ways1 = 0;

    if (coins[curr_idx] <= amount) {
      ways1 = num_ways(amount - coins[curr_idx], coins, dp, curr_idx);
    }

    int ways2 = num_ways(amount, coins, dp, curr_idx + 1);

    dp[curr_idx][amount] = ways1 + ways2;
  }

  return dp[curr_idx][amount];
}

// O(Na) / O(na)
int num_ways(int amount, const vector<int> &coins) {
  if (amount == 0 || coins.empty()) {
    return 1;
  }

  vector<vector<int>> dp(coins.size(), vector<int>(amount + 1, -1));
  return num_ways(amount, coins, dp, 0);
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