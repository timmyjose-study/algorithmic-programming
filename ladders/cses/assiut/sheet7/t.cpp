#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, r;
  cin >> n >> r;

  if (n < r) {
    cout << 0 << "\n";
    return 0;
  }

  vector<vector<unsigned long long>> a(n + 1,
                                       vector<unsigned long long>(n + 1));
  for (int i = 0; i <= n; i++) {
    for (int j = 0; j <= n; j++) {
      a[i][j] = 0;
    }
  }

  for (int i = 0; i <= n; i++) {
    a[i][0] = a[i][i] = 1;
    a[i][1] = i;
  }

  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
    }
  }

  cout << a[n][r] << "\n";

  return 0;
}