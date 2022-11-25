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

bool can_parition(const vector<int> &a, int sum, int curr_idx) {
  if (sum == 0) {
    return true;
  }

  if (curr_idx >= a.size()) {
    return false;
  }

  bool can1 = false;
  if (a[curr_idx] <= sum) {
    can1 = can_parition(a, sum - a[curr_idx], curr_idx + 1);
  }

  return can1 || can_parition(a, sum, curr_idx + 1);
}

// O(2n) / O(n)
bool can_parition(const vector<int> &a) {
  int sum = 0;
  for (int e : a) {
    sum += e;
  }

  if (sum % 2 != 0 || a.empty()) {
    return false;
  }

  return can_parition(a, sum / 2, 0);
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

    cout << (can_parition(a) ? "true" : "false") << "\n";
  }

  return 0;
}