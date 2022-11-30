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

// O(n) / O(n)
int num_factors(int n) {
  if (n == 0) {
    return 1;
  }

  if (n == 1) {
    return 1;
  }

  if (n == 2) {
    return 1;
  }

  if (n == 3) {
    return 2;
  }

  vector<int> dp(n + 1, 0);
  dp[0] = 1;
  dp[1] = 1;
  dp[2] = 1;
  dp[3] = 2;

  for (int i = 4; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
  }

  return dp[n];
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << num_factors(n) << "\n";
  }

  return 0;
}