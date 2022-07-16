#include <iostream>

using namespace std;

int main() {
  int tt, w1, w2, r1, r2, m;

  cin >> tt;
  while (tt--) {
    cin >> w1 >> w2 >> r1 >> r2 >> m;

    if ((w2 >= w1 + m * r1) && (w2 <= w1 + m * r2)) {
      cout << 1 << "\n";
    } else {
      cout << 0 << "\n";
    }
  }

  return 0;
}