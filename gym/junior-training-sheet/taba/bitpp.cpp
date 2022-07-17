#include <iostream>
#include <string>

int main() {
  int n, x = 0;
  std::string s;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> s;

    if (s[0] == '+' || s[1] == '+') {
      x++;
    } else {
      x--;
    }
  }

  std::cout << x << std::endl;

  return 0;
}