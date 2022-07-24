#include <algorithm>
#include <array>
#include <iostream>

using namespace std;

const int N = (int)1e5 + 10;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;

  cin >> tt;
  while (tt--) {
    cin >> n >> k;

    array<int, N> a, b;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      b[(i + k) % n] = a[i];
    }

    for (int i = 0; i < n; i++) {
      cout << b[i] << " ";
    }
    cout << "\n";
  }

  return 0;
}