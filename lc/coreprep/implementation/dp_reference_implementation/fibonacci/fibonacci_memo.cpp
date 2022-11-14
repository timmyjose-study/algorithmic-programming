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

long fibonacci(int n, vector<long> &dp) {
  if (n < 2) {
    return n;
  }

  if (dp[n] != 0) {
    return dp[n];
  }

  dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);

  return dp[n];
}

// O(n) / O(n)
long fibonacci(int n) {
  vector<long> dp(n + 1);
  return fibonacci(n, dp);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << fibonacci(n) << "\n";
  }

  return 0;
}