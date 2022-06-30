#include <algorithm>
#include <cctype>
#include <iostream>
#include <string>

int main() {
  std::string s;

  std::cin >> s;

  int lc = 0, uc = 0;
  for (auto c : s) {
    if (std::islower(c)) {
      lc++;
    } else {
      uc++;
    }
  }

  if (lc >= uc) {
    std::transform(s.begin(), s.end(), s.begin(),
                   [](unsigned char c) { return std::tolower(c); });

  } else {
    std::transform(s.begin(), s.end(), s.begin(),
                   [](unsigned char c) { return std::toupper(c); });
  }

  std::cout << s << std::endl;

  return 0;
}