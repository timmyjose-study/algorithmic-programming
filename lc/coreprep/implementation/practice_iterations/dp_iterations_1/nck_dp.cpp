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

// o(nk) / O(nk)
long nck(int n, int k) {
  vector<vector<long>> dp(n + 1, vector<long>(k + 1, 0));

  for (int i = 0; i <= n; i++) {
    dp[i][0] = 1;

    if (i <= k) {
      dp[i][i] = 1;
    }
  }

  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= k; j++) {
      dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
    }
  }

  return dp[n][k];
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