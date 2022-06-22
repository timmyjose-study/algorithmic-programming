#include <iostream>
#include <string>

int main() {
  int n;

  std::cin >> n;

  int g = 0;
  std::string s = "";
  std::string t;

  for (int i = 0; i < n; i++) {
    std::cin >> t;
    if (s.empty()) {
      s = t;
      g++;
    } else if (s[1] != t[0]) {
      s += t;
    } else {
      g++;
      s = t;
    }
  }

  std::cout << g << std::endl;

  return 0;
}