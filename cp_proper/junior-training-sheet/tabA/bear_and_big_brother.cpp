#include <iostream>

using namespace std;

int main() {
  int l, b, y = 0;
  cin >> l >> b;

  while (l <= b) {
    l *= 3;
    b *= 2;
    y++;
  }

  cout << y << "\n";

  return 0;
}