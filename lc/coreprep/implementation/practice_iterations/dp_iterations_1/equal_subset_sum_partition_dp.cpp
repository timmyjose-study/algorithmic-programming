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
void print_selected_items(const vector<int> &a, int sum,
                          const vector<vector<bool>> &dp) {
  unordered_set<int> indices;
  for (int i = a.size() - 1; i > 0; i--) {
    if (dp[i][sum] != dp[i - 1][sum]) {
      indices.insert(i);
      sum -= a[i];
    }
  }

  if (sum != 0) {
    indices.insert(0);
  }

  vector<int> sub1, sub2;
  for (int i = 0; i < a.size(); i++) {
    if (indices.find(i) != indices.end()) {
      sub1.push_back(a[i]);
    } else {
      sub2.push_back(a[i]);
    }
  }

  for (int item : sub1) {
    cout << item << " ";
  }
  cout << "\n";

  for (int item : sub2) {
    cout << item << " ";
  }
  cout << "\n";
}

// o(ns) / O(ns)
bool can_partition(const vector<int> &a) {
  int sum = 0;
  for (int e : a) {
    sum += e;
  }

  if (sum % 2 != 0 || a.empty()) {
    return false;
  }

  vector<vector<bool>> dp(a.size(), vector<bool>(sum / 2 + 1, false));

  for (int i = 0; i < a.size(); i++) {
    dp[i][0] = true;
  }

  for (int s = 0; s <= sum / 2; s++) {
    if (a[0] == s) {
      dp[0][s] = true;
    }
  }

  for (int i = 1; i < a.size(); i++) {
    for (int s = 1; s <= sum / 2; s++) {
      dp[i][s] = dp[i - 1][s];

      if (a[i] <= s) {
        dp[i][s] = dp[i - 1][s] || dp[i - 1][s - a[i]];
      }
    }
  }

  if (dp[a.size() - 1][sum / 2]) {
    print_selected_items(a, sum / 2, dp);
    return true;
  }
  return false;
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

    cout << (can_partition(a) ? "true" : "false") << "\n";
  }

  return 0;
}