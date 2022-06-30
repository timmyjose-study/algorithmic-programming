#include <algorithm>
#include <cmath>
#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <vector>

int main() {
  int n, d;
  std::vector<int> v;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> d;
    v.push_back(d);
  }

  int min_diff = abs(v[0] - v[1]);
  int x = 0, y = 1;

  for (int i = 1; i < n - 1; i++) {
    if (abs(v[i] - v[i + 1]) < min_diff) {
      x = i;
      y = i + 1;
      min_diff = abs(v[i] - v[i + 1]);
    }
  }

  if (abs(v[0] - v[n - 1]) < min_diff) {
    x = 0;
    y = n - 1;
  }

  std::cout << (x + 1) << " " << (y + 1) << std::endl;

  return 0;
}