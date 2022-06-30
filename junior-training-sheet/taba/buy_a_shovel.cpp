#include <iostream>

int main() {
  int k, r;

  std::cin >> k >> r;

  for (int i = 1;; i++) {
    if (((i * k) % 10) == 0 || ((i * k - r) % 10 == 0)) {
      std::cout << i << std::endl;
      break;
    }
  }

  return 0;
}