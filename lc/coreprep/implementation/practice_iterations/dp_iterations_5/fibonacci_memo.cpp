#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

// O(n) / O(n)
long long fibonacci(long n, vector<long> &dp) {
  if (n < 2) {
    return n;
  }

  if (dp[n] == -1) {
    dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
  }
  return dp[n];
}

long fibonacci(long n) {
  vector<long> dp(n + 1, -1);
  return fibonacci(n, dp);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  long n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << fibonacci(n) << "\n";
  }

  return 0;
}