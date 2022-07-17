#include <algorithm>
#include <array>
#include <iostream>

using namespace std;

const int N = 20;

int main() {
  int tt, n;
  array<int, N> a;

  auto Check = [&](array<int, N> a) {
    for (int i = 0; i < 7; i++) {
      if (!a[i]) {
        return false;
      }
    }
    return true;
  };

  cin >> tt;

  while (tt--) {
    cin >> n;

    int cnt = 0;
    array<int, N> b;
    b.fill(0);

    for (int i = 0; i < n; i++) {
      if (!Check(b)) {
        cnt++;
      }
      cin >> a[i];
      b[a[i] - 1] = 1;
    }

    cout << cnt << "\n";
  }

  return 0;
}