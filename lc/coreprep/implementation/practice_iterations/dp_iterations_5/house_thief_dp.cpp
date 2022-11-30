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

int max_loot(const vector<int> &a) {
  if (a.empty()) {
    return 0;
  }

  vector<int> dp(a.size() + 1, 0);
  dp[0] = 0; // no houses, no profit
  dp[1] = a[0];

  for (int i = 1; i < a.size(); i++) {
    dp[i + 1] = max(a[i] + dp[i - 1], dp[i]);
  }

  return dp[a.size()];
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