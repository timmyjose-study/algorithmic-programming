#include <cmath>
#include <iostream>
#include <string>

int main() {
  int n, z = 0, o = 0;
  std::string s;

  std::cin >> n;
  std::cin >> s;

  for (auto c : s) {
    if (c == '1')
      o++;
    else
      z++;
  }

  std::cout << abs(z - o) << std::endl;

  return 0;
}