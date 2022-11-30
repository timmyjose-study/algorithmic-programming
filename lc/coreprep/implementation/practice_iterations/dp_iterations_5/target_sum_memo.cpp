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

int count_ways(const vector<int> &a, int sum, vector<vector<int>> &dp,
               int curr_idx) {
  if (sum == 0) {
    return 1;
  }

  if (curr_idx >= a.size()) {
    return 0;
  }

  if (dp[curr_idx][sum] == -1) {
    int cnt1 = 0;
    if (a[curr_idx] <= sum) {
      cnt1 = count_ways(a, sum - a[curr_idx], dp, curr_idx + 1);
    }

    int cnt2 = count_ways(a, sum, dp, curr_idx + 1);

    dp[curr_idx][sum] = cnt1 + cnt2;
  }

  return dp[curr_idx][sum];
}

// O(ns) / O(ns)
int count_ways(const vector<int> &a, int sum) {
  if (a.empty()) {
    return 0;
  }

  int total = 0;
  for (int e : a) {
    total += e;
  }

  if ((total + sum) % 2 != 0) {
    return 0;
  }

  vector<vector<int>> dp(a.size(), vector<int>((total + sum) / 2 + 1, -1));
  return count_ways(a, (total + sum) / 2, dp, 0);
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

    cout << count_ways(a, sum) << "\n";
  }

  return 0;
}