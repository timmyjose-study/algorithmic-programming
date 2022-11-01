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
int bitonic_array_maximum(const vector<int> &a) {
  int low = 0, high = a.size() - 1;

  while (low < high) {
    int mid = low + (high - low) / 2;

    if (a[mid] < a[mid + 1]) {
      low = mid + 1;
    } else {
      high = mid;
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

    cout << bitonic_array_maximum(a) << "\n";
  }

  return 0;
}