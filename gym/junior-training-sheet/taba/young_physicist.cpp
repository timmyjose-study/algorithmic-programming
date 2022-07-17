#include <iostream>

int main() {
  int n, a, b, c, x = 0, y = 0, z = 0;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> a >> b >> c;
    x += a;
    y += b;
    z += c;
  }

  if (!x && !y && !z) {
    std::cout << "YES\n";
  } else {
    std::cout << "NO\n";
  }

  return 0;
}