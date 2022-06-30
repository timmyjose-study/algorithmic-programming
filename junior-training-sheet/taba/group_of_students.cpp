#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

int main() {
  int n, d, x, y;
  std::vector<int> v;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> d;
    v.push_back(d);
  }

  for (int i = 1; i < n; i++) {
    v[i] += v[i - 1];
  }

  std::cin >> x >> y;

  int bsum = 0, isum = 0;
  for (int i = 0; i < n; i++) {
    bsum = i == 0 ? 0 : v[i - 1];
    isum = v[n - 1] - bsum;

    if (bsum >= x && bsum <= y && isum >= x && isum <= y) {
      std::cout << (i + 1) << std::endl;
      return 0;
    }
  }

  std::cout << 0 << std::endl;

  return 0;
}