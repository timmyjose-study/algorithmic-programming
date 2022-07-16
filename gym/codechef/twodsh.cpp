#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int tt, n, a, b, c;

  cin >> tt;
  while (tt--) {
    cin >> n >> a >> b >> c;

    int d1 = (2 * min(a, b)) / 2;

    b -= a;
    if (b <= 0) {
      cout << "NO\n";
      continue;
    }

    int d2 = (2 * min(c, b)) / 2;
    if (d1 + d2 >= n) {
      cout << "YES\n";
    } else {
      cout << "NO\n";
    }
  }

  return 0;
}