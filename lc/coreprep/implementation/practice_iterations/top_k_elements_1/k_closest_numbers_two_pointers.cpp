#include <algorithm>
#include <iostream>
#include <queue>
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

  if (low > 0) {
    low--;
  }

  return low;
}

// O(logn + k) / O(1)
vector<int> k_closest_numbers(const vector<int> &a, int k, int x) {
  int n = a.size();
  int xpos = binary_search(a, 0, n - 1, x);
  deque<int> q;

  int left = xpos, right = xpos + 1;
  for (int i = 0; i < k; i++) {
    if (left >= 0 && right <= n - 1) {
      if (abs(a[left] - x) < abs(a[right] - x)) {
        q.push_front(a[left]);
        left--;
      } else {
        q.push_back(a[right]);
        right++;
      }
    } else if (left >= 0) {
      q.push_front(a[left]);
      left--;
    } else {
      q.push_back(a[right]);
      right++;
    }
  }

  vector<int> res(q.begin(), q.end());
  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k, x;
  cin >> tt;

  while (tt--) {
    cin >> n >> k >> x;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = k_closest_numbers(a, k, x);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}