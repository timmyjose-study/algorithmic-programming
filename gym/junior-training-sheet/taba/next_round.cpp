#include <iostream>
#include <unordered_map>

int main() {
  int n, k, s;
  std::unordered_map<int, int> m;

  std::cin >> n >> k;
  for (int i = 0; i < n; i++) {
    std::cin >> s;
    m[i] = s;
  }

  int c = 0;
  for (auto p : m) {
    if (p.second >= m[k - 1] & p.second > 0) {
      c++;
    }
  }

  std::cout << c << std::endl;

  return 0;
}