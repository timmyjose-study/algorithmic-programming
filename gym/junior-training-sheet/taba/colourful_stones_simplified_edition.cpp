#include <iostream>
#include <string>

int main() {
  std::string s, t;
  int pos = 1;

  std::cin >> s >> t;
  for (int i = 0; i < t.size(); i++) {
    if (t[i] == s[pos - 1]) {
      pos++;
    }
  }

  std::cout << pos << std::endl;

  return 0;
}