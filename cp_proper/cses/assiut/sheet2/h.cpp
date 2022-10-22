#include <cmath>
#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto is_prime = [](int n) {
    for (int i = 2; i <= round(sqrt(n)); i++) {
      if (n % i == 0) {
        return "NO";
      }
    }
    return "YES";
  };

  int n;
  cin >> n;

  cout << is_prime(n) << "\n";

  return 0;
}