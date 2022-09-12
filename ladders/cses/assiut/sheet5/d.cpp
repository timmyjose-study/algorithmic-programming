#include <cmath>
#include <iostream>

using namespace std;

bool is_prime(int n) {
  if (n == 1) {
    return false;
  }

  for (int i = 2; i <= round(sqrt(n)); i++) {
    if (n % i == 0) {
      return false;
    }
  }
  return true;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << (is_prime(n) ? "YES" : "NO") << "\n";
  }

  return 0;
}