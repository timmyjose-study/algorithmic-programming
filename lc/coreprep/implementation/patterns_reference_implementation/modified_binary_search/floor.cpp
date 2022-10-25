#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(logn) / O(1)
int floor(const vector<int> &a, int low, int high, int k) {
  if (a[0] > k) {
    return -1;
  }

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

  return high;
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

    cout << floor(a, 0, n - 1, k) << "\n";
  }

  return 0;
}