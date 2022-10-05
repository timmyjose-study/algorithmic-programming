#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int binary_searcH(const vector<int> &a, int low, int high, int elem) {
  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] == elem) {
      return mid;
    } else if (a[mid] < elem) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }

  return -1;
}

// O(nlogn) / O(1)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, s;
  cin >> tt;

  while (tt--) {
    cin >> n >> s;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    int lpos = -1, rpos = -1;
    for (int i = 0; i < n; i++) {
      rpos = binary_searcH(a, 0, n - 1, s - a[i]);
      if (rpos != -1) {
        lpos = i;
        break;
      }
    }

    cout << lpos << " " << rpos << "\n";
  }

  return 0;
}