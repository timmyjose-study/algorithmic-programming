#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void swap_row(vector<vector<int>> &a, int x, int y) {
  int n = a.size();
  for (int i = 0; i < n; i++) {
    int t = a[x][i];
    a[x][i] = a[y][i];
    a[y][i] = t;
  }
}

void swap_col(vector<vector<int>> &a, int x, int y) {
  int n = a.size();
  for (int i = 0; i < n; i++) {
    int t = a[i][x];
    a[i][x] = a[i][y];
    a[i][y] = t;
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, x, y;
  cin >> n >> x >> y;

  vector<vector<int>> a;
  for (int i = 0; i < n; i++) {
    vector<int> v(n);
    for (int i = 0; i < n; i++) {
      cin >> v[i];
    }
    a.emplace_back(v);
  }

  swap_row(a, x - 1, y - 1);
  swap_col(a, x - 1, y - 1);

  for (auto r : a) {
    for (auto c : r) {
      cout << c << " ";
    }
    cout << "\n";
  }

  return 0;
}