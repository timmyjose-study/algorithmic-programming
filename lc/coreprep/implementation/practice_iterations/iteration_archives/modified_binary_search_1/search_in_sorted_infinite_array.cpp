#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

struct ArrayReader {
  vector<int> a;

  ArrayReader(vector<int> a) : a(std::move(a)) {}

  int get(int idx) const {
    if (idx >= a.size()) {
      return numeric_limits<int>::max();
    }
    return this->a[idx];
  }
};

// O(logn) / O(1)
int binary_search(const ArrayReader &arr, int k) {
  int size = 1;

  while (arr.get(size - 1) != numeric_limits<int>::max() &&
         arr.get(size - 1) < k) {
    size *= 2;
  }

  int low = 0, high = size - 1;
  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (arr.get(mid) < k) {
      low = mid + 1;
    } else if (arr.get(mid) > k) {
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