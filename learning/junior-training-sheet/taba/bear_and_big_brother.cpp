#include <iostream>

int main() {
  int l, b, y = 0;

  std::cin >> l >> b;
  while (l <= b) {
    l *= 3;
    b *= 2;
    y++;
  }

  std::cout << y << std::endl;

  return 0;
}