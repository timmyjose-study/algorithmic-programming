#include <iostream>
#include <vector>

int main() {
  int n, a, p;
  std::vector<std::pair<int, int>> v;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> a >> p;
    v.push_back(std::make_pair<>(a, p));
  }

  int t = 0;
  int i = 0, j = 0;

  while (i < n) {
    j = i + 1;

    if (v[i].second < v[j].second) {
      t += v[i].first * v[i].second;
      while (j < n && v[i].second <= v[j].second) {
        t += v[i].second * v[j].first;
        j++;
      }

      i = j;
    } else {

      if (i < n) {
        t += v[i].first * v[i].second;
      }

      i++;
    }
  }

  std::cout << t << std::endl;

  return 0;
}