#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

struct SmallLarge {
  int small;
  int large;

  SmallLarge()
      : small(numeric_limits<int>::max()), large(numeric_limits<int>::min()) {}
};

int process_range(const vector<vector<int>> &a, int n, int m, int mid,
                  SmallLarge &range) {
  int row = n - 1, col = 0;
  int cnt = 0;

  while (row >= 0 && col < m) {
    if (a[row][col] > mid) {
      range.small = min(range.small, a[row][col]);
      row--;
    } else {
      range.large = max(range.large, a[row][col]);
      cnt += row + 1;
      col++;
    }
  }

  return cnt;
}

// O(n log(max - min)) / O(1)
int kth_smallest_in_sorted_matrix(const vector<vector<int>> &a, int k) {
  int n = a.size(), m = a[0].size();
  int low = a[0][0], high = a[n - 1][m - 1];

  while (low < high) {
    int mid = low + (high - low) / 2;

    SmallLarge range;
    int count = process_range(a, n, m, mid, range);

    if (count == k) {
      return range.large;
    } else if (count < k) {
      low = range.small;
    } else {
      high = range.large;
    }
  }

  return low;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, m, k, nq;
  cin >> tt;

  while (tt--) {
    cin >> n >> m;

    vector<vector<int>> a(n, vector<int>(m, 0));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        cin >> a[i][j];
      }
    }

    cin >> nq;
    while (nq--) {
      cin >> k;
      cout << kth_smallest_in_sorted_matrix(a, k) << "\n";
    }
  }

  return 0;
}