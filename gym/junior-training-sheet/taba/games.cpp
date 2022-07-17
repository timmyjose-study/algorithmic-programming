#include <iostream>
#include <vector>

int main() {
  int n, h, g;
  std::vector<std::pair<int, int>> v;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> h >> g;
    v.push_back(std::make_pair<>(h, g));
  }

  int c = 0;
  for (int i = 0; i < n - 1; i++) {
    for (int j = i + 1; j < n; j++) {
      if (v[i].first == v[j].second) {
        c++;
      }

      if (v[j].first == v[i].second) {
        c++;
      }
    }
  }

  std::cout << c << std::endl;

  return 0;
}