#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  long long nq, x, y;
  cin >> nq;

  while (nq--) {
    cin >> x >> y;

    long long d = max(x, y);

    if (y % 2 == 0) {
      cout << (d * (d - 1) + 1 - abs(x - y)) << "\n";
    } else {
      cout << (d * (d - 1) + 1 + abs(x - y)) << "\n";
    }
  }

  return 0;
}