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

int lpss(const string &s, int start_idx, int end_idx, vector<vector<int>> &dp) {
  if (start_idx > end_idx) {
    return 0;
  }

  if (start_idx == end_idx) {
    return 1;
  }

  if (dp[start_idx][end_idx] == -1) {
    if (s[start_idx] == s[end_idx]) {
      dp[start_idx][end_idx] = 2 + lpss(s, start_idx + 1, end_idx - 1, dp);
      return dp[start_idx][end_idx];
    }
  }

  dp[start_idx][end_idx] = max(lpss(s, start_idx + 1, end_idx, dp),
                               lpss(s, start_idx, end_idx - 1, dp));

  return dp[start_idx][end_idx];
}

// O(n2) / O(n2)
int lpss(const string &s) {
  if (s.empty()) {
    return 0;
  }

  vector<vector<int>> dp(s.size(), vector<int>(s.size(), -1));
  return lpss(s, 0, s.size() - 1, dp);
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