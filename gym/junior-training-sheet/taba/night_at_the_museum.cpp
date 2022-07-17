#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>

#define VAL(c) (c - 'a')

int main() {
  std::string s;

  std::cin >> s;

  int sol = 0;
  char c = 'a';
  for (int i = 0; i < s.size(); i++) {
    int d = abs(VAL(c) - VAL(s[i]));
    c = s[i];
    sol += std::min(d, 26 - d);
  }

  std::cout << sol << std::endl;

  return 0;
}