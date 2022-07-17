#include <algorithm>
#include <cctype>
#include <iostream>
#include <string>

int lexico(std::string s1, std::string s2) {
  unsigned s1len = s1.size();
  unsigned s2len = s2.size();

  for (int i = 0; i < std::min(s1len, s2len); i++) {
    if (s1[i] < s2[i]) {
      return -1;
    } else if (s1[i] > s2[i]) {
      return 1;
    }
  }

  if (s1len < s2len) {
    return -1;
  } else if (s1len == s2len) {
    return 0;
  } else {
    return 1;
  }
}

int main() {
  std::string s1, s2;

  std::cin >> s1 >> s2;
  std::transform(s1.begin(), s1.end(), s1.begin(),
                 [](unsigned char c) { return std::tolower(c); });
  std::transform(s2.begin(), s2.end(), s2.begin(),
                 [](unsigned char c) { return std::tolower(c); });

  std::cout << lexico(s1, s2) << std::endl;

  return 0;
}