#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int c;
  int xpos = -1, ypos = -1;

  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      cin >> c;
      if (c == 1) {
        xpos = i;
        ypos = j;
      }
    }
  }

  cout << abs(xpos - 2) + abs(ypos - 2) << "\n";

  return 0;
}