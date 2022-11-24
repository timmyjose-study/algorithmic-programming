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

// O(ns) / O(ns)
int min_diff(const vector<int> &a) {
  int sum = 0;
  for (int e : a) {
    sum += e;
  }

  vector<vector<bool>> dp(a.size(), vector<bool>(sum / 2 + 1, false));

  for (int i = 0; i < a.size(); i++) {
    dp[i][0] = true;
  }

  for (int s = 0; s <= sum / 2; s++) {
    if (a[0] == s) {
      dp[0][s] = true;
      break;
    }
  }

  for (int i = 1; i < a.size(); i++) {
    for (int s = 1; s <= sum / 2; s++) {
      dp[i][s] = dp[i - 1][s];

      if (a[i] <= s) {
        dp[i][s] = dp[i][s] || dp[i - 1][s - a[i]];
      }
    }
  }

  int sum1 = 0;
  for (int i = sum / 2; i >= 0; i--) {
    if (dp[a.size() - 1][i]) {
      sum1 = i;
      break;
    }
  }

  int sum2 = sum - sum1;

  return abs(sum1 - sum2);
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

    cout << min_diff(a) << "\n";
  }

  return 0;
}