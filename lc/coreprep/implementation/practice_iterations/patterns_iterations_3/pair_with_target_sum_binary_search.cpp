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

int binary_search(const vector<int> &a, int low, int high, int k) {
  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] < k) {
      low = mid + 1;
    } else if (a[mid] > k) {
      high = mid - 1;
    } else {
      return mid;
    }
  }

  return -1;
}

// O(nlogn) / O(1)
pair<int, int> pair_with_target_sum(const vector<int> &a, int s) {
  for (int i = 0; i < a.size(); i++) {
    int idx = binary_search(a, 0, a.size() - 1, s - a[i]);
    if (idx != -1) {
      return make_pair<>(i, idx);
    }
  }

  return make_pair<>(-1, -1);
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

    auto [pos1, pos2] = pair_with_target_sum(a, s);
    cout << pos1 << " " << pos2 << "\n";
  }

  return 0;
}