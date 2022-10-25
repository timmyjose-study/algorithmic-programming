#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

const int N = 50;

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

  vector<unsigned long long> a(N + 1);
  vector<bool> b(N + 1);
  a[1] = 0;
  a[2] = 1;
  for (int i = 3; i <= N; i++) {
    a[i] = a[i - 1] + a[i - 2];
    b[i] = is_prime(a[i]);
  }

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << (b[n] ? "prime" : "not prime") << "\n";
  }

  return 0;
}