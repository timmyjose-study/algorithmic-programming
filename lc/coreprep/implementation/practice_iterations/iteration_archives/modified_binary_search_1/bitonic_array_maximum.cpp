#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(logn) / O(1)
int bitonic_maximum(const vector<int> &a, int low, int high) {
  while (low < high) {
    int mid = low + (high - low) / 2;

    if (a[mid] > a[mid + 1]) {
      high = mid;
    } else {
      low = mid + 1;
    }
  }

  return a[low];
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << bitonic_maximum(a, 0, n - 1) << "\n";
  }

  return 0;
}