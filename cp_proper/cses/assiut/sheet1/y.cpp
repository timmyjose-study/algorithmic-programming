#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  long long a, b, c, d;

  cin >> a >> b >> c >> d;

  a %= 1000;
  b %= 1000;
  c %= 1000;
  d %= 1000;

  long long m = a * b * c * d;
  cout << ((m / 10) % 10) << (m % 10) << "\n";

  return 0;
}