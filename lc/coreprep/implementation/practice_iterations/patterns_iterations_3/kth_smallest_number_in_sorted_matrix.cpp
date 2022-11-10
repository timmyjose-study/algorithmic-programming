#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

struct Range {
  int ceil;
  int floor;

  Range(int ceil, int floor) : ceil(ceil), floor(floor) {}
};

int count(const vector<vector<int>> &a, int n, int m, int mid, Range &range) {
  int row = n - 1, col = 0;
  int cnt = 0;

  while (row >= 0 && col < m) {
    if (a[row][col] > mid) {
      range.ceil = min(range.ceil, a[row][col]);
      row--;
    } else {
      range.floor = max(range.floor, a[row][col]);
      col++;
      cnt += row + 1;
    }
  }

  return cnt;
}

// O(n x log(max - min)) / O(1)
int kth_smallest(const vector<vector<int>> &a, int n, int m, int k) {
  int low = a[0][0], high = a[n - 1][m - 1];

  while (low < high) {
    int mid = low + (high - low) / 2;

    Range range(a[n - 1][m - 1], a[0][0]);
    int cnt = count(a, n, m, mid, range);

    if (cnt < k) {
      low = range.ceil;
    } else if (cnt > k) {
      high = range.floor;
    } else {
      return range.floor;
    }
  }

  return high;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, m, nq, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> m;

    vector<vector<int>> a(n, vector<int>(m));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        cin >> a[i][j];
      }
    }

    cin >> nq;
    while (nq--) {
      cin >> k;
      cout << kth_smallest(a, m, n, k) << "\n";
    }
  }

  return 0;
}