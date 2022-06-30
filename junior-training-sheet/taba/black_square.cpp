#include <iostream>
#include <string>

int main() {
  int m[4] = {0};

  for (int i = 0; i < 4; i++) {
    std::cin >> m[i];
  }

  std::string s;
  std::cin >> s;

  int sol = 0;
  for (auto c : s) {
    sol += m[(c - '0') - 1];
  }

  std::cout << sol << std::endl;

  return 0;
}