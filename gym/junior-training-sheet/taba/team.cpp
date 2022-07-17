#include <iostream>

int main() {
  int n;
  int a, b, c;
  int sol = 0;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> a >> b >> c;
    if ((a + b + c) >= 2) {
      sol++;
    }
  }

  std::cout << sol << std::endl;

  return 0;
}