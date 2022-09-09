#include <cmath>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

const double EPS = 1e-9;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long a, b, c, d;
  cin >> a >> b >> c >> d;

  double log1 = b * log(a);
  double log2 = d * log(c);

  if (log1 > log2 + EPS) {
    cout << "YES\n";
  } else {
    cout << "NO\n";
  }

  return 0;
}