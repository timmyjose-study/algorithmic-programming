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

int target_sum(const vector<int> &a, int sum, int arr_sum, int curr_idx) {
  if (curr_idx == a.size() && arr_sum == sum) {
    return 1;
  }

  if (curr_idx >= a.size()) {
    return 0;
  }

  int plus = target_sum(a, sum, arr_sum + a[curr_idx], curr_idx + 1);
  int minus = target_sum(a, sum, arr_sum - a[curr_idx], curr_idx + 1);

  return plus + minus;
}

int target_sum(const vector<int> &a, int sum) {
  return target_sum(a, sum, 0, 0);
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

    cout << target_sum(a, s) << "\n";
  }

  return 0;
}