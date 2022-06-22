#include <algorithm>
#include <iostream>
#include <vector>

int main() {
  int n, p, q;
  std::vector<std::pair<int, int>> v;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> p >> q;
    v.push_back(std::make_pair<>(p, q));
  }

  std::sort(v.begin(), v.end(), [](auto p1, auto p2) {
    if (p1.first < p2.first) {
      return true;
    } else if (p1.first == p2.first) {
      if (p1.second > p2.second) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  });

  for (int i = 0; i < n - 1; i++) {
    if (v[i].first < v[i + 1].first && v[i].second > v[i + 1].second) {
      std::cout << "Happy Alex\n";
      return 0;
    }
  }

  std::cout << "Poor Alex\n";

  return 0;
}