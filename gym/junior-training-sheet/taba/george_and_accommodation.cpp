#include <iostream>

int main() {
  int n, c, m, sol = 0;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> c >> m;
    if ((m - c) >= 2) {
      sol++;
    }
  }

  std::cout << sol << std::endl;

  return 0;
}