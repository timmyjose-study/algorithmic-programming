#include <iostream>
#include <vector>

int main() {
  int k, l, m, n, d;
  std::vector<bool> v;

  std::cin >> k >> l >> m >> n >> d;

  for (int i = 0; i < d; i++) {
    v.push_back(false);
  }

  for (int i = 1; i <= d; i++) {
    if (((i % k) == 0) || ((i % l) == 0) || ((i % m) == 0) || ((i % n) == 0)) {
      v[i - 1] = true;
    }
  }

  int c = 0;
  for (int i = 0; i < d; i++) {
    if (v[i]) {
      c++;
    }
  }

  std::cout << c << std::endl;

  return 0;
}