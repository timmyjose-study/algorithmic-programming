#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

int main() {
  std::string s;

  std::cin >> s;

  if (s.size() <= 1) {
    std::cout << 0 << std::endl;
    return 0;
  }

  int zc = s.size() - 1;
  bool has_one = false;

  for (int i = 1; i < s.size(); i++) {
    if (s[i] == '1') {
      has_one = true;
      break;
    }
  }

  zc = has_one ? zc / 2 + 1 : zc / 2;

  std::cout << zc << std::endl;

  return 0;
}