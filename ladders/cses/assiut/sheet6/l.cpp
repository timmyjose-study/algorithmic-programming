#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<vector<unsigned long long>> a(n + 1,
                                       vector<unsigned long long>(n + 1));

  for (int i = 1; i <= n; i++) {
    a[i][i] = a[i][0] = 1;
    a[i][1] = a[i][i - 1] = i;
  }

  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
    }
  }

  for (int i = 1; i <= n; i++) {
    for (int j = 0; j < i; j++) {
      cout << a[i][j] << " ";
    }
    cout << "\n";
  }

  return 0;
}