#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto is_valid = [](const vector<vector<char>> &a, int n, int m, int x,
                     int y) {
    if (y > 0 && a[x][y - 1] != 'x') {
      return false;
    }
    if (x > 0 && y > 0 && a[x - 1][y - 1] != 'x') {
      return false;
    }

    if (x > 0 && a[x - 1][y] != 'x') {
      return false;
    }

    if (x > 0 && y < m - 1 && a[x - 1][y + 1] != 'x') {
      return false;
    }

    if (y < m - 1 && a[x][y + 1] != 'x') {
      return false;
    }

    if (x < n - 1 && y < m - 1 && a[x + 1][y + 1] != 'x') {
      return false;
    }

    if (x < n - 1 && a[x + 1][y] != 'x') {
      return false;
    }

    if (x < n - 1 && y > 0 && a[x + 1][y - 1] != 'x') {
      return false;
    }

    return true;
  };

  int n, m, x, y;
  string s;
  cin >> n >> m;

  vector<vector<char>> a;
  for (int i = 0; i < n; i++) {
    cin >> s;
    vector<char> v;
    for (int j = 0; j < m; j++) {
      v.emplace_back(s[j]);
    }
    a.emplace_back(v);
  }

  cin >> x >> y;
  x--;
  y--;

  cout << (is_valid(a, n, m, x, y) ? " yes " : " no ") << "\n";

  return 0;
}