#include <algorithm>
#include <iostream>

int main() {
  long long n;

  std::cin >> n;

  if (n >= 0) {
    std::cout << n << std::endl;
  } else {
    long long c1 = n / 10;
    long long c2 = (n / 10 / 10) * 10 + (n % 10);
    std::cout << std::max(c1, c2) << std::endl;
  }

  return 0;
}