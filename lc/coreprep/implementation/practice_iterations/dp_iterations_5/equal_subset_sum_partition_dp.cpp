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

void print_selected_items(const vector<int> &a, int sum,
                          const vector<vector<bool>> &dp) {
  unordered_set<int> chosen;

  for (int i = a.size() - 1; i > 0; i--) {
    if (dp[i][sum] != dp[i - 1][sum]) {
      chosen.insert(i);
      sum -= a[i];
    }
  }

  if (sum != 0) {
    chosen.insert(0);
  }

  vector<int> items1, items2;
  for (int i = 0; i < a.size(); i++) {
    if (chosen.find(i) != chosen.end()) {
      items1.push_back(a[i]);
    } else {
      items2.push_back(a[i]);
    }
  }

  for (int item : items1) {
    cout << item << " ";
  }
  cout << "\n";

  for (int item : items2) {
    cout << item << " ";
  }
  cout << "\n";
}

// O(ns) / O(ns)
bool can_partition(const vector<int> &a) {
  int sum = 0;
  for (int e : a) {
    sum += e;
  }

  if (sum % 2 != 0) {
    return false;
  }

  sum /= 2;
  vector<vector<bool>> dp(a.size(), vector<bool>(sum + 1, false));

  for (int i = 0; i < a.size(); i++) {
    dp[i][0] = true;
  }

  for (int s = 0; s <= sum; s++) {
    if (a[0] == s) {
      dp[0][s] = true;
      break;
    }
  }

  for (int i = 1; i < a.size(); i++) {
    for (int s = 1; s <= sum; s++) {
      dp[i][s] = dp[i - 1][s];

      if (a[i] <= s) {
        dp[i][s] = dp[i][s] || dp[i - 1][s - a[i]];
      }
    }
  }

  if (dp[a.size() - 1][sum]) {
    print_selected_items(a, sum, dp);
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