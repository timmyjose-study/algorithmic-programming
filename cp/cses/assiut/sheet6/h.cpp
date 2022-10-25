#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto gcd = [](unsigned long long n, unsigned long long m) {
    while (m) {
      unsigned long long t = n % m;
      n = m;
      m = t;
    }
    return n;
  };

  auto lcm = [&](unsigned long long n, unsigned long long m) {
    return (n * m) / gcd(n, m);
  };

  unsigned long long n, m;
  cin >> n >> m;
  cout << gcd(n, m) << " " << lcm(n, m) << "\n";

  return 0;
}