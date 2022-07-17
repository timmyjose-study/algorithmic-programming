#include <iostream>

int main() {
  int n;
  std::string s;

  std::cin >> n >> s;

  int a = 0, d = 0;
  for (const auto c : s) {
    if (c == 'A') {
      a++;
    } else {
      d++;
    }
  }

  if (a > d) {
    std::cout << "Anton\n";
  } else if (a < d) {
    std::cout << "Danik\n";
  } else {
    std::cout << "Friendship\n";
  }

  return 0;
}