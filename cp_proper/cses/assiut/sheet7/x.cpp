#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

int maxpath(vector<vector<int>> const &a, int i, int j, int n, int m) {
  if (i == n - 1 && j == m - 1) {
    return a[i][j];
  }

  int maxsum = numeric_limits<int>::min();

  if (i < n - 1) {
    int lsum = maxpath(a, i + 1, j, n, m);
    if (a[i][j] + lsum > maxsum) {
      maxsum = a[i][j] + lsum;
    }
  }

  if (j < m - 1) {
    int rsum = maxpath(a, i, j + 1, n, m);
    if (a[i][j] + rsum > maxsum) {
      maxsum = a[i][j] + rsum;
    }
  }

  return maxsum;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m;
  cin >> n >> m;

  vector<vector<int>> a(n, vector<int>(m));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> a[i][j];
    }
  }

  cout << maxpath(a, 0, 0, n, m) << "\n";

  return 0;
}