#include <algorithm>
#include <iostream>
#include <queue>
#include <string>
#include <vector>

using namespace std;

int count_less_equal(const vector<vector<int>> &a, int mid,
                     pair<int, int> &small_large) {
  int cnt = 0;
  int n = a.size();
  int m = a[0].size();
  int row = n - 1, col = 0;

  while (row >= 0 && col < m) {
    if (a[row][col] > mid) {
      small_large.second = min(small_large.second, a[row][col]);
      row--;
    } else {
      small_large.first = max(small_large.first, a[row][col]);
      cnt += row + 1;
      col++;
    }
  }

  return cnt;
}

// O(n x log(max - mnin)) / O(1)
int kth_smallest_in_sorted_matrix(const vector<vector<int>> &a, int k) {
  int n = a.size();
  int m = a[0].size();

  int start = a[0][0];
  int end = a[n - 1][m - 1];

  while (start < end) {
    int mid = start + (end - start) / 2;
    pair<int, int> small_large(start, end);

    int count = count_less_equal(a, mid, small_large);

    if (count == k) {
      return small_large.first;
    } else if (count < k) {
      start = small_large.second;
    } else {
      end = small_large.first;
    }
  }

  return start;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, m, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> m;

    vector<vector<int>> a(n, vector<int>(m));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        cin >> a[i][j];
      }
    }

    int nq;
    cin >> nq;

    while (nq--) {
      cin >> k;

      cout << kth_smallest_in_sorted_matrix(a, k) << "\n";
    }
  }

  return 0;
}