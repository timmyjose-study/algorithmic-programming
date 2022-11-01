#include <algorithm>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

// O(logn) / O(1)
int ceiling(const vector<int> &a, int low, int high, int elem) {
  if (a[high] < elem) {
    return -1;
  }

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] < elem) {
      low = mid + 1;
    } else if (a[mid] > elem) {
      high = mid - 1;
    } else {
      return mid;
    }
  }

  return low;
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

    cout << ceiling(a, 0, n - 1, k) << "\n";
  }

  return 0;
}