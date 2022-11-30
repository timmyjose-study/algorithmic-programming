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

int max_loot(const vector<int> &a, vector<int> &dp, int curr_idx) {
  if (curr_idx >= a.size()) {
    return 0;
  }

  if (dp[curr_idx] == -1) {
    int loot1 = a[curr_idx] + max_loot(a, dp, curr_idx + 2);
    int loot2 = max_loot(a, dp, curr_idx + 1);
    dp[curr_idx] = max(loot1, loot2);
  }

  return dp[curr_idx];
}

// O(n) / O(n)
int max_loot(const vector<int> &a) {
  if (a.empty()) {
    return 0;
  }

  vector<int> dp(a.size(), -1);
  return max_loot(a, dp, 0);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << max_loot(a) << "\n";
  }

  return 0;
}