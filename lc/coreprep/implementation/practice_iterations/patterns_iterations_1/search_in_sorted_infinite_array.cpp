#include <algorithm>
#include <iostream>
#include <limits>
#include <string>
#include <vector>

using namespace std;

struct ArrayReader {
  const vector<int> a;

  ArrayReader(const vector<int> a) : a(std::move(a)) {}

  int get(int idx) const {
    if (idx >= a.size()) {
      return numeric_limits<int>::max();
    }
    return a[idx];
  }
};

// O(logn) / O(1)
int binary_search(const ArrayReader &a, int k) {
  int low = 0, high = 1;

  while (a.get(high) < k) {
    int new_low = high + 1;
    high += (high - low + 1) * 2;
    low = new_low;
  }

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a.get(mid) < k) {
      low = mid + 1;
    } else if (a.get(mid) > k) {
      high = mid - 1;
    } else {
      return mid;
    }
  }

  return -1;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    ArrayReader arr(a);
    cout << binary_search(arr, k) << "\n";
  }

  return 0;
}