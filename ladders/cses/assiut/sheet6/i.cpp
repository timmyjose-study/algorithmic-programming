#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  long long n, m, x;
  cin >> n >> m >> x;

  if (n > m) {
    unsigned long long t = n;
    n = m;
    m = t;
  }

  while (n % x) {
    n++;
  }

  while (m % x) {
    m--;
  }

  unsigned long long nterms = (m - n) / x + 1;
  unsigned long long sol = ((n + m) * nterms) / 2;
  cout << sol << "\n";

  return 0;
}