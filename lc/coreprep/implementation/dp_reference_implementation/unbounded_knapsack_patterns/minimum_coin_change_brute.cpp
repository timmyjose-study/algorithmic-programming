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

int min_change(int amount, const vector<int> &coins, int curr_idx) {
  if (amount == 0) {
    return 0;
  }

  if (curr_idx >= coins.size()) {
    return numeric_limits<int>::max();
  }

  int ways1 = numeric_limits<int>::max();

  if (coins[curr_idx] <= amount) {
    int res = min_change(amount - coins[curr_idx], coins, curr_idx);

    if (res != numeric_limits<int>::max()) {
      ways1 = 1 + res;
    }
  }

  int ways2 = min_change(amount, coins, curr_idx + 1);

  return min(ways1, ways2);
}

// O(2n) / O(n)
int min_change(int amount, const vector<int> &coins) {
  if (amount == 0 || coins.empty()) {
    return -1;
  }

  int res = min_change(amount, coins, 0);

  return (res == numeric_limits<int>::max() ? -1 : res);
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

    cout << min_change(amount, coins) << "\n";
  }

  return 0;
}