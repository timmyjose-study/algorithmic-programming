#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(logn) / O(1)
int minimum_difference(const vector<int> &a, int low, int high, int k) {
  if (k < a[low]) {
    return a[low];
  }

  if (k > a[high]) {
    return a[high];
  }

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] == k) {
      return a[mid];
    } else if (a[mid] < k) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }

  return (abs(k - a[low]) < abs(k - a[high])) ? a[low] : a[high];
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

    cout << minimum_difference(a, 0, n - 1, k) << "\n";
  }

  return 0;
}