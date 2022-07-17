#include <algorithm>
#include <iostream>
#include <vector>

int main() {
  int n, d;
  std::vector<int> v;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> d;
    v.push_back(d);
  }

  std::sort(v.begin(), v.end());

  for (const auto &e : v) {
    std::cout << e << " ";
  }
  std::cout << std::endl;

  return 0;
}