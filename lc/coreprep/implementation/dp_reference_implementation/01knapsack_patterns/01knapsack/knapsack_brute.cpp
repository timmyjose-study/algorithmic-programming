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
             int curr_idx, int n, int capacity) {
  if (curr_idx >= n || capacity <= 0) {
    return 0;
  }

  int profit1 = 0;

  if (weights[curr_idx] <= capacity) {
    profit1 = profits[curr_idx] + knapsack(profits, weights, curr_idx + 1, n,
                                           capacity - weights[curr_idx]);
  }

  int profit2 = knapsack(profits, weights, curr_idx + 1, n, capacity);

  return max(profit1, profit2);
}

// O(2n) / O(n)
int knapsack(const vector<int> &profits, const vector<int> &weights, int n,
             int c) {
  return knapsack(profits, weights, 0, n, c);
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

    cout << knapsack(profits, weights, n, c) << "\n";
  }

  return 0;
}