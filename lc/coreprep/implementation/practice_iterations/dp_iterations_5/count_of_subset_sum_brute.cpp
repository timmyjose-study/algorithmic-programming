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

int count_subsets(const vector<int> &a, int sum, int curr_idx) {
  if (sum == 0) {
    return 1;
  }

  if (curr_idx >= a.size()) {
    return 0;
  }

  int cnt = count_subsets(a, sum, curr_idx + 1);

  if (a[curr_idx] <= sum) {
    cnt += count_subsets(a, sum - a[curr_idx], curr_idx + 1);
  }

  return cnt;
}

// O(2n) / O(n)
int count_subsets(const vector<int> &a, int sum) {
  if (a.empty()) {
    return 0;
  }

  return count_subsets(a, sum, 0);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, sum;
  cin >> tt;

  while (tt--) {
    cin >> n >> sum;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << count_subsets(a, sum) << "\n";
  }

  return 0;
}