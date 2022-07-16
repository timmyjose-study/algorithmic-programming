#include <iostream>

using namespace std;

int main() {
  int tt, l, r;

  cin >> tt;
  while (tt--) {
    cin >> l >> r;
    cout << (2 * r - 2 * l + 1) << "\n";
  }

  return 0;
}