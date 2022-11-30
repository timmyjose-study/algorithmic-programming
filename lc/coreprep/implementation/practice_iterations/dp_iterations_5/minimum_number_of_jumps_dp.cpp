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

// O(n2) / O(n)
int min_jumps(const vector<int> &a) {
  if (a.empty()) {
    return 0;
  }

  vector<int> dp(a.size(), numeric_limits<int>::max());
  dp[0] = 0;

  for (int start = 0; start < a.size(); start++) {
    for (int end = start + 1; end < a.size() && end <= start + a[start];
         end++) {
      dp[end] = min(dp[end], 1 + dp[start]);
    }
  }

  return dp[a.size() - 1];
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

    cout << min_jumps(a) << "\n";
  }

  return 0;
}