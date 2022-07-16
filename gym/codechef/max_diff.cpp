#include <iostream>

using namespace std;

int main() {
  int tt, m, s;

  cin >> tt;
  while (tt--) {
    cin >> m >> s;
    if (m >= s) {
      cout << s << "\n";
    } else {
      cout << (2 * m - s) << "\n";
    }
  }

  return 0;
}