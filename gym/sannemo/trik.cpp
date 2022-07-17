#include <iostream>
#include <string>

using namespace std;

int main() {
  string s;

  cin >> s;

  int x = 1, y = 0, z = 0, t;
  for (char c : s) {
    if (c == 'A') {
      t = x;
      x = y;
      y = t;
    } else if (c == 'B') {
      t = y;
      y = z;
      z = t;
    } else {
      t = x;
      x = z;
      z = t;
    }
  }

  cout << (x == 1 ? 1 : (y == 1 ? 2 : 3)) << "\n";

  return 0;
}