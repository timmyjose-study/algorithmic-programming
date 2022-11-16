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

int knapsack(const vector<int> &profits, const vector<int> &weights,
             int capacity, vector<vector<int>> &dp, int curr_idx) {
  if (curr_idx >= profits.size() || capacity == 0) {
    return 0;
  }

  if (dp[curr_idx][capacity] != -1) {
    return dp[curr_idx][capacity];
  }

  dp[curr_idx][capacity] =
      knapsack(profits, weights, capacity, dp, curr_idx + 1);

  if (weights[curr_idx] <= capacity) {
    dp[curr_idx][capacity] =
        max(dp[curr_idx][capacity],
            profits[curr_idx] + knapsack(profits, weights,
                                         capacity - weights[curr_idx], dp,
                                         curr_idx + 1));
  }

  return dp[curr_idx][capacity];
}

// O(nc) / O(nc)
int knapsack(const vector<int> &profits, const vector<int> &weights,
             int capacity) {
  if (profits.empty()) {
    return 0;
  }

  vector<vector<int>> dp(profits.size(), vector<int>(capacity + 1, -1));
  return knapsack(profits, weights, capacity, dp, 0);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, c;
  cin >> tt;

  while (tt--) {
    cin >> n >> c;

    vector<int> profits(n);
    for (int i = 0; i < n; i++) {
      cin >> profits[i];
    }

    vector<int> weights(n);
    for (int i = 0; i < n; i++) {
      cin >> weights[i];
    }

    cout << knapsack(profits, weights, c) << "\n";
  }

  return 0;
}