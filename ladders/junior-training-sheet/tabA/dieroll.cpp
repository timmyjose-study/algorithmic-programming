#include <algorithm>
#include <iostream>

using namespace std;

int gcd(int m, int n) {
  if (n == 0) {
    return m;
  }
  return gcd(n, m % n);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int y, w;

  cin >> y >> w;

  int s = max(y, w);
  int c = 6 - s + 1;
  int g = gcd(c, 6);

  cout << (c / g) << "/" << (6 / g) << "\n";

  return 0;
}