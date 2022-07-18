#include <iostream>

using namespace std;

int main() {
  int n, d = 0;

  cin >> n;
  while (n) {
    d = 2 * d + (n % 2);
    n >>= 1;
  }

  cout << d << "\n";

  return 0;
}