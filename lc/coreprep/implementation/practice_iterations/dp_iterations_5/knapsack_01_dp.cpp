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

// O(N) / O(1)
void print_selected_items(const vector<int> &profits,
                          const vector<int> &weights, int capacity,
                          const vector<vector<int>> &dp) {
  int profit = dp[weights.size() - 1][capacity];
  vector<int> items;

  for (int i = weights.size() - 1; i > 0; i--) {
    if (dp[i][capacity] != dp[i - 1][capacity]) {
      items.push_back(weights[i]);
      capacity -= weights[i];
      profit -= profits[i];
    }
  }

  if (profit != 0) {
    items.push_back(weights[0]);
  }

  for (int item : items) {
    cout << item << " ";
  }
  cout << "\n";
}

// O(nc) / O(nc)
void knapsack(const vector<int> &profits, const vector<int> &weights,
              int capacity) {
  vector<vector<int>> dp(weights.size(), vector<int>(capacity + 1, 0));

  for (int i = 0; i < weights.size(); i++) {
    dp[i][0] = 0;
  }

  for (int c = 0; c <= capacity; c++) {
    if (weights[0] <= c) {
      dp[0][c] = weights[0];
    }
  }

  for (int i = 1; i < weights.size(); i++) {
    for (int c = 1; c <= capacity; c++) {
      int profit1 = 0;
      if (weights[i] <= c) {
        profit1 = profits[i] + dp[i - 1][c - weights[i]];
      }

      int profit2 = dp[i - 1][c];

      dp[i][c] = max(profit1, profit2);
    }
  }

  cout << dp[weights.size() - 1][capacity] << "\n";
  print_selected_items(profits, weights, capacity, dp);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, capacity;

  cin >> tt;
  while (tt--) {
    cin >> n >> capacity;

    vector<int> profits(n);
    for (int i = 0; i < n; i++) {
      cin >> profits[i];
    }

    vector<int> weights(n);
    for (int i = 0; i < n; i++) {
      cin >> weights[i];
    }

    knapsack(profits, weights, capacity);
  }

  return 0;
}