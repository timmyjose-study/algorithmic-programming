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

int min_jumps(const vector<int> &a, vector<int> &dp, int curr_idx) {
  if (curr_idx == a.size() - 1) {
    return 0;
  }

  if (curr_idx >= a.size()) {
    return numeric_limits<int>::max();
  }

  if (dp[curr_idx] == -1) {
    int curr_jumps = numeric_limits<int>::max();
    int start = curr_idx + 1;
    int end = curr_idx + a[curr_idx];

    while (start < a.size() && start <= end) {
      int next_jumps = min_jumps(a, dp, start);
      if (next_jumps != numeric_limits<int>::max()) {
        curr_jumps = min(curr_jumps, 1 + next_jumps);
      }
      start++;
    }

    dp[curr_idx] = curr_jumps;
  }

  return dp[curr_idx];
}

// O(n2) / O(n)
int min_jumps(const vector<int> &a) {
  if (a.empty()) {
    return 0;
  }

  vector<int> dp(a.size() + 1, -1);
  return min_jumps(a, dp, 0);
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