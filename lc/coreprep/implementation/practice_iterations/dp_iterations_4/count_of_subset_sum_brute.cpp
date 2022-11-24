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

int count_subsets(const vector<int> &a, int sum, int curr_sum, int curr_idx) {
  if (sum == curr_sum) {
    return 1;
  }

  if (curr_idx >= a.size()) {
    return 0;
  }

  int ways1 = 0;
  if (a[curr_idx] <= sum) {
    ways1 = count_subsets(a, sum, curr_sum + a[curr_idx], curr_idx + 1);
  }

  int ways2 = count_subsets(a, sum, curr_sum, curr_idx + 1);

  return ways1 + ways2;
}

// O(2n) / O(n)
int count_subsets(const vector<int> &a, int sum) {
  return count_subsets(a, sum, 0, 0);
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

    cout << count_subsets(a, s) << "\n";
  }

  return 0;
}