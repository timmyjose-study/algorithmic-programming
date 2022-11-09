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

// O(logn) / O(1)
int binary_search(const vector<int> &a, int low, int high, int k) {
  bool is_inc = a[low] <= a[high];

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] < k) {
      if (is_inc) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    } else if (a[mid] > k) {
      if (is_inc) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    } else {
      return mid;
    }
  }

  return -1;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << binary_search(a, 0, n - 1, k) << "\n";
  }

  return 0;
}