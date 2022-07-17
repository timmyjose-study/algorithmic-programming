#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

int main() {
  int n;

  std::cin >> n;

  int sol = 0;
  while (n) {
    sol += n & 1;
    n >>= 1;
  }

  std::cout << sol << std::endl;

  return 0;
}