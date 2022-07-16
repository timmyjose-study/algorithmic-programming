#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int tt, x1, y1, x2, y2, k;

  cin >> tt;
  while (tt--) {
    cin >> x1 >> y1 >> x2 >> y2 >> k;

    int d = abs(x1 - x2) + abs(y1 - y2);
    if (k < d) {
      cout << "NO\n";
    } else {
      cout << (k % 2 == d % 2 ? "YES" : "NO") << "\n";
    }
  }

  return 0;
}