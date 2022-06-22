#include <iostream>

int main() {
  int n, e, p = 0, c = 0;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> e;

    if (e == -1) {
      if (p > 0) {
        p--;
      } else {
        c++;
      }
    } else {
      p += e;
    }
  }

  std::cout << c << std::endl;

  return 0;
}