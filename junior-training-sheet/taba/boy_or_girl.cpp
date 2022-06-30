#include <iostream>
#include <string>

int main() {
  std::string s;
  int m[26] = {0};

  std::cin >> s;

  for (auto c : s) {
    m[c - 'a']++;
  }

  int uc = 0;
  for (int i = 0; i < 26; i++) {
    if (m[i] != 0) {
      uc++;
    }
  }

  std::cout << (uc % 2 == 1 ? "IGNORE HIM!" : "CHAT WITH HER!") << std::endl;

  return 0;
}