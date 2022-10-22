#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto sigma = [](unsigned long long n) { return n * (n + 1) / 2; };

  long long n, m, x;
  cin >> n >> m >> x;

  if (n > m) {
    unsigned long long t = n;
    n = m;
    m = t;
  }

  cout << (sigma(m / x) * x - sigma((n - 1) / x) * x) << "\n";

  return 0;
}