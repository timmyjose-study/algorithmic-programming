#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

int main() {
  int x, y, z;

  std::cin >> x >> y >> z;

  int h = sqrt(z * y / x);
  int l = (x * h) / y;
  int b = y / h;

  std::cout << (4 * (l + b + h)) << std::endl;

  return 0;
}