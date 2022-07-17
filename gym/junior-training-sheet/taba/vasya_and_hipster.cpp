#include <algorithm>
#include <iostream>

int main() {
  int r, b;

  std::cin >> r >> b;

  int x = std::min(r, b);
  int y = (std::max(r, b) - x) / 2;
  std::cout << x << " " << y << std::endl;

  return 0;
}