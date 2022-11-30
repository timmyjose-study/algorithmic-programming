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

// O(ns) / O(s)
int count_subsets(const vector<int> &a, int sum) {
  if (a.empty()) {
    return 0;
  }

  vector<int> dp(sum + 1, 0);
  dp[0] = 1;

  for (int i = 0; i < a.size(); i++) {
    for (int s = sum; s >= 0; s--) {
      if (a[i] <= s) {
        dp[s] += dp[s - a[i]];
      }
    }
  }

  return dp[sum];
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, sum;
  cin >> tt;

  while (tt--) {
    cin >> n >> sum;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << count_subsets(a, sum) << "\n";
  }

  return 0;
}