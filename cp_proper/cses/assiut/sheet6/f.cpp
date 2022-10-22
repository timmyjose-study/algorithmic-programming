#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void mult(vector<vector<int>> const &a, int r1, int c1,
          vector<vector<int>> const &b, int c2, vector<vector<int>> &c) {
  for (int i = 0; i < r1; i++) {
    for (int j = 0; j < c2; j++) {
      int e = 0;
      for (int k = 0; k < c1; k++) {
        e += a[i][k] * b[k][j];
      }
      c[i][j] = e;
    }
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int r1, c1, r2, c2;
  cin >> r1 >> c1;

  vector<vector<int>> a(r1, vector<int>(c1));
  for (int i = 0; i < r1; i++) {
    for (int j = 0; j < c1; j++) {
      cin >> a[i][j];
    }
  }

  cin >> r2 >> c2;

  vector<vector<int>> b(r2, vector<int>(c2));
  for (int i = 0; i < r2; i++) {
    for (int j = 0; j < c2; j++) {
      cin >> b[i][j];
    }
  }

  vector<vector<int>> c(r1, vector<int>(c2));
  mult(a, r1, c1, b, c2, c);

  for (auto row : c) {
    for (int e : row) {
      cout << e << " ";
    }
    cout << "\n";
  }

  return 0;
}