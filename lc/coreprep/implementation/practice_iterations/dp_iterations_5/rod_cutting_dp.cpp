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

// O(n) / O(1)
void print_selected_items(const vector<int> &profits,
                          const vector<int> &lengths, int length,
                          const vector<vector<int>> &dp) {
  vector<int> items;
  int profit = dp[lengths.size() - 1][length];

  for (int i = lengths.size() - 1; i > 0; i--) {
    if (dp[i][length] != dp[i - 1][length]) {
      items.push_back(lengths[i]);
      profit -= profits[i];
      length -= lengths[i];
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
void max_cut_profit(const vector<int> &profits, const vector<int> &lengths,
                    int length) {
  if (lengths.empty() || length == 0) {
    cout << 0 << "\n";
    return;
  }

  vector<vector<int>> dp(lengths.size(), vector<int>(length + 1, 0));

  for (int i = 0; i < lengths.size(); i++) {
    dp[i][0] = 0;
  }

  for (int l = 0; l <= length; l++) {
    if (lengths[0] <= l) {
      dp[0][l] = profits[0];
    }
  }

  for (int i = 0; i < lengths.size(); i++) {
    for (int l = 1; l <= length; l++) {
      if (lengths[i] <= l) {
        dp[i][l] = profits[i] + dp[i][l - lengths[i]];
      }

      if (i > 0) {
        dp[i][l] = max(dp[i][l], dp[i - 1][l]);
      }
    }
  }

  cout << dp[lengths.size() - 1][length] << "\n";
  print_selected_items(profits, lengths, length, dp);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, length;
  cin >> tt;

  while (tt--) {
    cin >> n >> length;

    vector<int> profits(n);
    for (int i = 0; i < n; i++) {
      cin >> profits[i];
    }

    vector<int> lengths(n);
    for (int i = 0; i < n; i++) {
      cin >> lengths[i];
    }

    max_cut_profit(profits, lengths, length);
  }

  return 0;
}