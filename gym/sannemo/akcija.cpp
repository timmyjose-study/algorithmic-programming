#include <algorithm>
#include <array>
#include <iostream>

using namespace std;

const int N = (int)1e5 + 10;

int main() {
  int n;
  array<int, N> a;

  a.fill(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  sort(a.begin(), a.begin() + n, greater<int>());

  int long long cost = 0LL;
  int pos = 0;
  while (pos < n - 2) {
    cost += a[pos] + a[pos + 1];
    pos += 3;
  }

  for (int i = pos; i < n; i++) {
    cost += a[i];
  }

  cout << cost << "\n";

  return 0;
}