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

int max_profits(const vector<int> &prices, const vector<int> &lengths,
                int length, int curr_idx) {
  if (length == 0) {
    return 0;
  }

  if (curr_idx >= lengths.size()) {
    return 0;
  }

  int profit1 = 0;

  if (lengths[curr_idx] <= length) {
    profit1 =
        prices[curr_idx] +
        max_profits(prices, lengths, length - lengths[curr_idx], curr_idx);
  }

  int profit2 = max_profits(prices, lengths, length, curr_idx + 1);

  return max(profit1, profit2);
}

// O(2n) / O(n)
int max_profit(const vector<int> &prices, const vector<int> &lengths,
               int length) {
  if (lengths.empty() || length == 0) {
    return 0;
  }

  return max_profits(prices, lengths, length, 0);
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