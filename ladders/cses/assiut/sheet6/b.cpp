#include <cmath>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto is_prime = [](unsigned long long n) {
    if (n <= 1) {
      return false;
    }

    for (unsigned long long i = 2; i <= round(sqrt(n)); i++) {
      if (!(n % i)) {
        return false;
      }
    }
    return true;
  };

  unsigned long long n;
  cin >> n;

  cout << (is_prime(n) ? "YES" : "NO") << "\n";

  return 0;
}