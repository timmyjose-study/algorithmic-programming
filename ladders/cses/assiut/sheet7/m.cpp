#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

long long msum(const vector<int> &a, int n, int m) {
  if (m == 0) {
    return 0LL;
  }

  return (long long)a[n - m] + msum(a, n, m - 1);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m;
  cin >> n >> m;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  cout << msum(a, n, m) << "\n";

  return 0;
}