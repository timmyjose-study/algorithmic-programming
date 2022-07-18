#include <iostream>

using namespace std;

int main() {
  int x, y;

  while (true) {
    cin >> x >> y;

    if (!x && !y) {
      break;
    }

    if (x + y == 13) {
      cout << "Never speak again.\n";
    } else if (x < y) {
      cout << "Left beehind.\n";
    } else if (x > y) {
      cout << "To the convention.\n";
    } else if (x == y) {
      cout << "Undecided.\n";
    }
  }

  return 0;
}