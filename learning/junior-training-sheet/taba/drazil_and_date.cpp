#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

int main() {
  int a, b, s;
  std::cin >> a >> b >> s;

  int t = std::abs(a) + std::abs(b);

  if (s < t) {
    std::cout << "No" << std::endl;
  } else if (t % 2 == 0) {
    if (s % 2 == 0) {
      std::cout << "Yes" << std::endl;
    } else {
      std::cout << "No" << std::endl;
    }
  } else {
    if (s % 2 == 1) {
      std::cout << "Yes" << std::endl;
    } else {
      std::cout << "No" << std::endl;
    }
  }

  return 0;
}