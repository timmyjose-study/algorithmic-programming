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

int min_fee(const vector<int> &a, vector<int> &dp, int curr_idx) {
  if (curr_idx >= a.size()) {
    return 0;
  }

  if (dp[curr_idx] == -1) {
    int jump1 = min_fee(a, dp, curr_idx + 1);
    int jump2 = min_fee(a, dp, curr_idx + 2);
    int jump3 = min_fee(a, dp, curr_idx + 3);

    dp[curr_idx] = a[curr_idx] + min(min(jump1, jump2), jump3);
  }

  return dp[curr_idx];
}

// O(n) / O(n)
int min_fee(const vector<int> &a) {
  if (a.empty()) {
    return 0;
  }

  vector<int> dp(a.size(), -1);
  return min_fee(a, dp, 0);
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

    cout << min_fee(a) << "\n";
  }

  return 0;
}