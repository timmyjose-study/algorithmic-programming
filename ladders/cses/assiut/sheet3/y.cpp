#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, nq, l, r;
  cin >> n >> nq;

  vector<long long> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  for (int i = 1; i < n; i++) {
    a[i] += a[i - 1];
  }

  while (nq--) {
    cin >> l >> r;
    l--;
    r--;

    cout << (l == 0 ? a[r] : a[r] - a[l - 1]) << "\n";
  }

  return 0;
}