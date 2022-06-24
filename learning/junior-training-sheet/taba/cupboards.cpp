#include <algorithm>
#include <iostream>

int main() {
  int n, l, r, lc = 0, lo = 0, rc = 0, ro = 0;

  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> l >> r;
    if (l == 0) {
      lo++;
    } else {
      lc++;
    }

    if (r == 0) {
      ro++;
    } else {
      rc++;
    }
  }

  std::cout << (std::min(lo, lc) + std::min(ro, rc)) << std::endl;

  return 0;
}