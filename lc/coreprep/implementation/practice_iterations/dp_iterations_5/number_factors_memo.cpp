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

int num_factors(int n, vector<int> &dp) {
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

  if (dp[n] == -1) {
    dp[n] = num_factors(n - 1, dp) + num_factors(n - 3, dp) +
            num_factors(n - 4, dp);
  }

  return dp[n];
}

// O(n) / O(n)
int num_factors(int n) {
  vector<int> dp(n + 1, -1);
  return num_factors(n, dp);
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