#include <cmath>
#include <iostream>

using namespace std;

unsigned long long pow(unsigned long long b, unsigned long long e) {
  unsigned long long res = 1ULL;
  for (unsigned long long i = 0; i < e; i++) {
    res *= b;
  }
  return res;
}

unsigned long long func(unsigned long long n, unsigned long long x) {
  unsigned long long res = 0ULL;
  for (unsigned long long i = 2; i <= n; i += 2) {
    res += pow(x, i);
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n, x;
  cin >> x >> n;
  cout << func(n, x) << "\n";

  return 0;
}