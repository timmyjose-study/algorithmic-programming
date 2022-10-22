#include <cmath>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto is_prime = [](int n) {
    for (int i = 2; i <= round(sqrt(n)); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  };

  int n;
  cin >> n;

  for (int i = 2; i <= n; i++) {
    if (is_prime(i)) {
      cout << i << " ";
    }
  }
  cout << "\n";

  return 0;
}