#include <iostream>
#include <string>

int main() {
  int n;
  std::string s;

  std::cin >> n >> s;

  int sol = 0;
  char c = s[0];

  for (unsigned i = 1; i < n; i++) {
    if (s[i] == c) {
      sol++;
    } else {
      c = s[i];
    }
  }

  std::cout << sol << std::endl;

  return 0;
}