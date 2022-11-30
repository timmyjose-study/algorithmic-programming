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

// O(nk) / O(nk)
int nck(int n, int k, vector<vector<int>> &dp) {
  if (k == 0 || n == k) {
    return 1;
  }

  if (dp[n][k] == -1) {
    dp[n][k] = nck(n - 1, k - 1, dp) + nck(n - 1, k, dp);
  }

  return dp[n][k];
}

int nck(int n, int k) {
  vector<vector<int>> dp(n + 1, vector<int>(k + 1, -1));

  return nck(n, k, dp);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;

  cin >> tt;
  while (tt--) {
    cin >> n >> k;
    cout << nck(n, k) << "\n";
  }

  return 0;
}