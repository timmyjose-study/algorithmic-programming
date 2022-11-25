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

void print_selected_items(const vector<int> &prices, const vector<int> &lengths,
                          int length, const vector<vector<int>> &dp) {
  int profit = dp[lengths.size() - 1][length];

  vector<int> items;
  for (int i = lengths.size() - 1; i > 0; i--) {
    if (dp[i][length] != dp[i - 1][length]) {
      items.push_back(lengths[i]);
      length -= lengths[i];
      profit -= prices[i];
    }
  }

  if (profit != 0) {
    items.push_back(lengths[0]);
  }

  for (int item : items) {
    cout << item << " ";
  }
  cout << "\n";
}

// O(nl) / O(nl)
void max_profit(const vector<int> &prices, const vector<int> &lengths,
                int length) {
  if (lengths.empty() || length == 0) {
    cout << "0"
         << "\n";
    return;
  }

  vector<vector<int>> dp(lengths.size(), vector<int>(length + 1, 0));

  for (int i = 0; i < lengths.size(); i++) {
    dp[i][0] = 0;
  }

  for (int i = 0; i < lengths.size(); i++) {
    for (int l = 1; l <= length; l++) {
      int profit1 = 0;

      if (lengths[i] <= l) {
        profit1 = prices[i] + dp[i][l - lengths[i]];
      }

      int profit2 = 0;
      if (i > 0) {
        profit2 = dp[i - 1][l];
      }

      dp[i][l] = max(profit1, profit2);
    }
  }

  cout << dp[lengths.size() - 1][length] << "\n";
  print_selected_items(prices, lengths, length, dp);
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

    max_profit(prices, lengths, length);
  }

  return 0;
}