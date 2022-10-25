#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto sigma = [](unsigned long long n) { return n * (n + 1) / 2; };

  int tt;
  cin >> tt;

  unsigned long long l, r;
  while (tt--) {
    cin >> l >> r;

    if (l > r) {
      unsigned long long t = l;
      l = r;
      r = t;
    }
    cout << (sigma(r) - sigma(l - 1)) << "\n";
  }

  return 0;
}