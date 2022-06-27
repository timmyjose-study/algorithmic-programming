#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

int main() {
  std::string s, t;

  std::cin >> s >> t;

  int h1 = (s[0] - '0') * 10 + (s[1] - '0');
  h1 += 24;

  int m1 = (s[3] - '0') * 10 + (s[4] - '0');
  int h2 = (t[0] - '0') * 10 + (t[1] - '0');
  int m2 = (t[3] - '0') * 10 + (t[4] - '0');

  int m = m1 - m2;
  if (m < 0) {
    m += 60;
    h1 -= 1;
  }

  int h = (h1 - h2) % 24;

  if (h < 10) {
    std::cout << 0 << h;
  } else {
    std::cout << h;
  }

  std::cout << ":";

  if (m < 10) {
    std::cout << 0 << m;
  } else {
    std::cout << m;
  }

  std::cout << std::endl;

  return 0;
}