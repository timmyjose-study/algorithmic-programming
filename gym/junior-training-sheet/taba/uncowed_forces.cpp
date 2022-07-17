#include <iostream>

int main() {
  int m1, m2, m3, m4, m5;
  std::cin >> m1 >> m2 >> m3 >> m4 >> m5;

  int w1, w2, w3, w4, w5;
  std::cin >> w1 >> w2 >> w3 >> w4 >> w5;

  int hs, hu;
  std::cin >> hs >> hu;

  int s = std::max(3 * 50, 2 * (250 - m1) - 50 * w1);
  s += std::max(3 * 100, 4 * (250 - m2) - 50 * w2);
  s += std::max(3 * 150, 6 * (250 - m3) - 50 * w3);
  s += std::max(3 * 200, 8 * (250 - m4) - 50 * w4);
  s += std::max(3 * 250, 10 * (250 - m5) - 50 * w5);
  s += 100 * hs;
  s -= 50 * hu;

  std::cout << s << std::endl;

  return 0;
}