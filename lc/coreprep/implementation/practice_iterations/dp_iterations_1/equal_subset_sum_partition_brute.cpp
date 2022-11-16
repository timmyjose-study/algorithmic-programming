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

bool can_partition(const vector<int> &a, int sum, int curr_idx) {
  if (sum == 0) {
    return true;
  }

  if (curr_idx >= a.size()) {
    return false;
  }

  bool can1 = false;

  if (a[curr_idx] <= sum) {
    can1 = can_partition(a, sum - a[curr_idx], curr_idx + 1);
  }

  return can1 || can_partition(a, sum, curr_idx + 1);
}

// o(2n) / O(n)
bool can_partition(const vector<int> &a) {
  int sum = 0;
  for (int e : a) {
    sum += e;
  }

  if (sum % 2 != 0 || a.empty()) {
    return false;
  }

  sum /= 2;
  return can_partition(a, sum, 0);
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