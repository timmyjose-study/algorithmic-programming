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

// O(nk) / O(k)
long nck(int n, int k) {
  vector<long> dp(k + 1);

  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    for (int j = min(i, k); j > 0; j--) {
      dp[j] = dp[j] + dp[j - 1];
    }
  }

  return dp[k];
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