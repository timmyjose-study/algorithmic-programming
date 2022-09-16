#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m, nq;
  cin >> n >> m >> nq;

  vector<vector<char>> a(n, vector<char>(m));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      a[i][j] = '.';
    }
  }

  int r1, c1, r2, c2;
  char c;

  while (nq--) {
    cin >> r1 >> c1 >> r2 >> c2 >> c;

    if (r1 > r2) {
      int r = r1;
      r1 = r2;
      r2 = r;

      int c = c1;
      c1 = c2;
      c2 = c;
    }

    for (int i = r1 - 1; i < r2; i++) {
      for (int j = c1 - 1; j < c2; j++) {
        a[i][j] = c;
      }
    }
  }

  for (auto r : a) {
    for (char c : r) {
      cout << c;
    }
    cout << "\n";
  }

  return 0;
}