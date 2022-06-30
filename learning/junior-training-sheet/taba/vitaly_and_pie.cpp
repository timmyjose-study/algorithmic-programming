#include <algorithm>
#include <cctype>
#include <iostream>
#include <string>
#include <unordered_map>

int main() {
  int n;
  std::string s;
  std::unordered_map<char, int> m;

  std::cin >> n >> s;

  int sol = 0;
  for (char c : s) {
    if (std::islower(c)) {
      if (m.find(c) == m.end()) {
        m[c] = 1;
      } else {
        m[c]++;
      }
    } else {
      if (m[std::tolower(c)] > 0) {
        m[std::tolower(c)]--;
      } else {
        sol++;
      }
    }
  }

  std::cout << sol << std::endl;

  return 0;
}