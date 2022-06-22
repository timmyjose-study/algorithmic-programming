#include <iostream>
#include <string>

int main() {
  int r, c;

  std::cin >> r >> c;

  int dir = 0;
  for (int i = 0; i < r; i++) {
    std::string s;

    if ((i % 2) == 0) {
      for (int j = 0; j < c; j++) {
        s += "#";
      }
    } else {
      for (int j = 0; j < c; j++) {
        s += ".";
      }

      if (!dir) {
        s[s.size() - 1] = '#';
        dir = 1;
      } else {
        s[0] = '#';
        dir = 0;
      }
    }

    std::cout << s << std::endl;
  }

  return 0;
}