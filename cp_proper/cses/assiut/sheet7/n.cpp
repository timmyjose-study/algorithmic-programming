#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void mat_sum(vector<vector<int>> &a, vector<vector<int>> &b, int row, int n,
             int col, int m) {
  if (row == n) {
    return;
  }

  if (col == m) {
    mat_sum(a, b, row + 1, n, 0, m);
  } else {
    a[row][col] += b[row][col];
    mat_sum(a, b, row, n, col + 1, m);
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m;
  cin >> n >> m;

  vector<vector<int>> a, b;
  for (int i = 0; i < n; i++) {
    vector<int> v(m);
    for (int j = 0; j < m; j++) {
      cin >> v[j];
    }
    a.emplace_back(v);
  }

  for (int i = 0; i < n; i++) {
    vector<int> v(m);
    for (int j = 0; j < m; j++) {
      cin >> v[j];
    }
    b.emplace_back(v);
  }

  mat_sum(a, b, 0, n, 0, m);

  for (auto r : a) {
    for (int c : r) {
      cout << c << " ";
    }
    cout << "\n";
  }

  return 0;
}