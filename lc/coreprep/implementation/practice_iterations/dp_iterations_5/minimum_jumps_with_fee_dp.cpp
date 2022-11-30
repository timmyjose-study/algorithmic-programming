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
int min_fee(const vector<int> &a) {
  if (a.empty()) {
    return 0;
  }

  vector<int> dp(a.size() + 1, 0);
  dp[0] = 0;
  dp[1] = a[0]; // since we can take 1, 2, or 3 steps
  dp[2] = a[0];
  dp[3] = a[0];

  for (int i = 3; i < a.size(); i++) {
    dp[i + 1] =
        min(a[i] + dp[i], min(a[i - 1] + dp[i - 1], a[i - 2] + dp[i - 2]));
  }

  return dp[a.size()];
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

    cout << min_fee(a) << "\n";
  }

  return 0;
}