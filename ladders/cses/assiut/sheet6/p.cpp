#include <cmath>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto num_digits = [](unsigned int n) -> unsigned int {
    double log = 0.0;
    if (n <= 1) {
      return 1;
    }

    for (int i = 2; i <= n; i++) {
      log += log10(i);
    }

    return floor(log) + 1;
  };

  unsigned int n;
  cin >> n;
  cout << "Number of digits of " << n << "! is " << num_digits(n) << "\n";

  return 0;
}