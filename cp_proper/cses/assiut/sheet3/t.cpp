#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, d;
  cin >> n;

  vector<vector<int>> a;
  for (int i = 0; i < n; i++) {
    vector<int> v;
    for (int j = 0; j < n; j++) {
      cin >> d;
      v.emplace_back(d);
    }
    a.emplace_back(v);
  }

  int sum1 = 0, sum2 = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (i == j) {
        sum1 += a[i][j];
      }

      if (i + j == n - 1) {
        sum2 += a[i][j];
      }
    }
  }

  cout << abs(sum1 - sum2) << "\n";

  return 0;
}