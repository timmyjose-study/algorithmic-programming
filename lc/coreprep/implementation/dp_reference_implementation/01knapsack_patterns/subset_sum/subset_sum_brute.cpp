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

bool has_subset(const vector<int> &a, int sum, int curr_idx) {
  if (sum == 0) {
    return true;
  }

  if (curr_idx >= a.size()) {
    return false;
  }

  bool has1 = false;
  if (a[curr_idx] <= sum) {
    has1 = has_subset(a, sum - a[curr_idx], curr_idx + 1);
  }

  return has1 || has_subset(a, sum, curr_idx + 1);
}

// O(2n) / O(n)
bool has_subset(const vector<int> &a, int sum) {
  if (a.empty()) {
    return false;
  }

  return has_subset(a, sum, 0);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, s;
  cin >> tt;

  while (tt--) {
    cin >> n >> s;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << (has_subset(a, s) ? "true" : "false") << "\n";
  }

  return 0;
}