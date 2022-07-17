#include <algorithm>
#include <array>
#include <iostream>

using namespace std;

const int N = 110;

int main() {
  int tt, n, x, y;
  array<int, N> a;

  cin >> tt;
  while (tt--) {
    cin >> n >> x >> y;
    a.fill(0);

    int d = x * y;
    int p;
    for (int i = 0; i < n; i++) {
      cin >> p;
      int lpos = max(1, p - d);
      int rpos = min(p + d, 100);

      for (int i = lpos - 1; i < rpos; i++) {
        a[i] = 1;
      }
    }

    int cnt = 0;
    for (int i = 0; i < 100; i++) {
      if (a[i] == 0) {
        cnt++;
      }
    }

    cout << cnt << "\n";
  }

  return 0;
}