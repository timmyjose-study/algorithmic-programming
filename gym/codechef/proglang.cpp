#include <array>
#include <iostream>

using namespace std;

int main() {
  int tt, x, y;
  array<int, 4> a;

  cin >> tt;
  while (tt--) {
    cin >> x >> y >> a[0] >> a[1] >> a[2] >> a[3];

    if ((a[0] == x && a[1] == y) || (a[0] == y && a[1] == x)) {
      cout << 1 << "\n";
    } else if ((a[2] == x && a[3] == y) || (a[2] == y && a[3] == x)) {
      cout << 2 << "\n";
    } else {
      cout << 0 << "\n";
    }
  }

  return 0;
}