#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int binary_search(const vector<int> &a, int low, int high, int elem) {
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
    for (int i = 0; i < a.size(); i++) {
      int sum = s - a[i];
      int idx = binary_search(a, 0, a.size() - 1, sum);
      if (idx != -1) {
        lpos = i;
        rpos = idx;
        break;
      }
    }

    cout << lpos << " " << rpos << "\n";
  }

  return 0;
}