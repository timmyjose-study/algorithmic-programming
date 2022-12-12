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

// O(nl) / O(nl)
int max_cut(int length, const vector<int> &lengths) {
  if (length == 0 || lengths.empty()) {
    return -1;
  }

  vector<vector<int>> dp(lengths.size(), vector<int>(length + 1, 0));

  for (int i = 0; i < lengths.size(); i++) {
    dp[i][0] = 0;
  }

  for (int i = 0; i < lengths.size(); i++) {
    for (int l = 1; l <= length; l++) {
      int ways1 = numeric_limits<int>::min();

      if (lengths[i] <= l) {
        int res = dp[i][l - lengths[i]];

        if (res != numeric_limits<int>::min()) {
          ways1 = 1 + res;
        }
      }

      dp[i][l] = ways1;

      if (i > 0) {
        dp[i][l] = max(dp[i][l], dp[i - 1][l]);
      }
    }
  }

  int res = dp[lengths.size() - 1][length];

  return (res == numeric_limits<int>::min() ? -1 : res);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, length;
  cin >> tt;

  while (tt--) {
    cin >> n >> length;

    vector<int> lengths(n);
    for (int i = 0; i < n; i++) {
      cin >> lengths[i];
    }

    cout << max_cut(length, lengths) << "\n";
  }

  return 0;
}