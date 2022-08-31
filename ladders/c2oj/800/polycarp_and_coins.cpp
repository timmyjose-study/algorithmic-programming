#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int tt, n;

  cin >> tt;
  while (tt--) {
    cin >> n;

    long long c1 = 0, c2 = 9999999999;
    for (long long i = 0; i <= n; i++) {
      bool found = false;
      for (long long j = i; j <= m; j++) {
        if (i + 2 * j > n) {
          break;
        }

        if (i + 2 * j == n && abs(i - j) < abs(c1 - c2)) {
          c1 = i;
          c2 = j;
          found = true;
        }
      }

      if (found) {
        break;
      }
    }

    cout << c1 << " " << c2 << "\n";
  }

  return 0;
}