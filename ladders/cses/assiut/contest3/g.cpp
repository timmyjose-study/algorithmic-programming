#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, d, ec = 0, oc = 0;
  cin >> tt;

  while (tt--) {
    cin >> n;

    for (int i = 0; i < n; i++) {
      cin >> d;

      if (d % 2 == 0) {
        ec++;
      } else {
        oc++;
      }
    }

    if (n % 2 == 1) {
      cout << -1 << "\n";
    } else {
      cout << (abs(ec - oc) / 2) << "\n";
    }
    ec = oc = 0;
  }

  return 0;
}