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

// O(n2) / O(n2)
int lpss(const string &s) {
  if (s.empty()) {
    return 0;
  }

  vector<vector<int>> dp(s.size(), vector<int>(s.size(), 0));

  for (int i = 0; i < s.size(); i++) {
    dp[i][i] = 1;
  }

  for (int start = s.size() - 1; start >= 0; start--) {
    for (int end = start + 1; end < s.size(); end++) {
      if (s[start] == s[end]) {
        int rem_len = end - start - 1;
        if (rem_len == dp[start + 1][end - 1]) {
          dp[start][end] = 2 + rem_len;
          continue;
        }
      }

      int len1 = dp[start + 1][end];
      int len2 = dp[start][end - 1];

      dp[start][end] = max(len1, len2);
    }
  }

  return dp[0][s.size() - 1];
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;

  cin >> tt;
  cin.ignore(numeric_limits<int>::max(), '\n');
  while (tt--) {
    getline(cin, s);
    cout << lpss(s) << "\n";
  }

  return 0;
}