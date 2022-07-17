#include <algorithm>
#include <iostream>
#include <map>

int main() {
  int n, d, tot = 0;
  std::map<std::pair<int, int>, int> m;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> d;
    tot += d;
    m[std::make_pair<>(i + 1, i + 2)] = d;
    m[std::make_pair<>(i + 2, i + 1)] = d;
  }

  int f, t;

  std::cin >> f >> t;

  if (f > t) {
    int m = f;
    f = t;
    t = m;
  }

  int sol = 0;
  for (int i = f; i < t; i++) {
    sol += m[std::make_pair<>(i, i + 1)];
  }

  sol = std::min(sol, tot - sol);
  std::cout << sol << std::endl;

  return 0;
}