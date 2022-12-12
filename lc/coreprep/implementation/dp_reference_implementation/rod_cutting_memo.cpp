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

int max_profit(const vector<int> &prices, const vector<int> &lengths,
               int length, vector<vector<int>> &dp, int curr_idx) {
  if (length == 0) {
    return 0;
  }

  if (curr_idx >= lengths.size()) {
    return 0;
  }

  if (dp[curr_idx][length] == -1) {
    int profit1 = 0;

    if (lengths[curr_idx] <= length) {
      profit1 =
          prices[curr_idx] +
          max_profit(prices, lengths, length - lengths[curr_idx], dp, curr_idx);
    }

    int profit2 = max_profit(prices, lengths, length, dp, curr_idx + 1);

    dp[curr_idx][length] = max(profit1, profit2);
  }

  return dp[curr_idx][length];
}

// O(nl) / O(nl)
int max_profit(const vector<int> &prices, const vector<int> &lengths,
               int length) {
  if (lengths.empty() || length == 0) {
    return 0;
  }

  vector<vector<int>> dp(lengths.size(), vector<int>(length + 1, -1));
  return max_profit(prices, lengths, length, dp, 0);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, length;
  cin >> tt;

  while (tt--) {
    cin >> n >> length;

    vector<int> prices(n);
    for (int i = 0; i < n; i++) {
      cin >> prices[i];
    }

    vector<int> lengths(n);
    for (int i = 0; i < n; i++) {
      cin >> lengths[i];
    }

    cout << max_profit(prices, lengths, length) << "\n";
  }

  return 0;
}