#include <cmath>
#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n;
  cin >> n;

  unsigned long long lim = round(sqrt(n));
  unsigned long long s = 0ULL;
  for (unsigned long long d = 1; d <= lim; d++) {
    if (!(n % d)) {
      s += d;

      if ((n / d) <= n && (n / d) != d) {
        s += n / d;
      }
    }
  }

  cout << s << "\n";

  return 0;
}