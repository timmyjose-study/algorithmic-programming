#include <algorithm>
#include <cmath>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int binary_search(const vector<int> &a, int low, int high, int x) {
  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] < x) {
      low = mid + 1;
    } else if (a[mid] > x) {
      high = mid - 1;
    } else {
      return mid;
    }
  }

  if (low > 0) {
    low--;
  }

  return low;
}

// O(logn + k) / O(1)
vector<int> k_closest(const vector<int> &a, int k, int x) {
  int xpos = binary_search(a, 0, a.size() - 1, x);
  int cnt = 0;

  int left = xpos, right = xpos + 1;
  vector<int> res;
  while (cnt < k) {
    if (abs(x - a[left]) < abs(x - a[right])) {
      res.push_back(a[left]);
      left--;
    } else {
      res.push_back(a[right]);
      right++;
    }
    cnt++;
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k, x;
  cin >> tt;

  while (tt--) {
    cin >> n >> k >> x;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = k_closest(a, k, x);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}