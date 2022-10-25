#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

unsigned long long factorial(unsigned long long n) {
  unsigned long long f = 1ULL;
  for (unsigned long long i = 2; i <= n; i++) {
    f *= i;
  }

  return f;
}

unsigned long long ncr(unsigned long long n, unsigned long long r) {
  return factorial(n) / factorial(n - r) / factorial(r);
}

unsigned long long npr(unsigned long long n, unsigned long long r) {
  return factorial(n) / factorial(n - r);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n, r;
  cin >> n >> r;

  cout << ncr(n, r) << " " << npr(n, r) << "\n";

  return 0;
}