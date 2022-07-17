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

  const char state[] = {'h', 'e', 'l', 'l', 'o'};
  int len = sizeof(state) / sizeof(char);
  int pc = 0;

  for (char c : s) {
    if (c == state[pc]) {
      pc++;
    }

    if (pc == len) {
      std::cout << "YES" << std::endl;
      return 0;
    }
  }

  std::cout << "NO" << std::endl;

  return 0;
}