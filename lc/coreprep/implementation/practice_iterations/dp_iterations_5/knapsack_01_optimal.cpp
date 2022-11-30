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

// O(nc) / O(c)
int knapsack(const vector<int> &profits, const vector<int> &weights,
             int capacity) {
  vector<int> dp(capacity + 1, 0);

  for (int c = 0; c <= capacity; c++) {
    dp[c] = 0;
  }

  for (int i = 0; i < weights.size(); i++) {
    for (int c = capacity; c > 0; c--) {
      if (weights[i] <= c) {
        dp[c] = profits[i] + dp[c - weights[i]];
      }
    }
  }

  return dp[capacity];
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

    cout << knapsack(profits, weights, capacity) << "\n";
  }

  return 0;
}