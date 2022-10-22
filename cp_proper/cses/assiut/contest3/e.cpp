#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n);

  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  int asign = a[0] >= 0 ? 1 : -1;
  int bsign = a[0] >= 0 ? -1 : 1;
  int ac = 0, bc = 0;

  for (int i = 0; i < n; i++) {
    if (a[i] >= 0) {
      if (asign == 1) {
        ac++;
      }

      if (bsign == 1) {
        bc++;
      }
    } else {
      if (asign == -1) {
        ac++;
      }

      if (bsign == -1) {
        bc++;
      }
    }

    asign *= -1;
    bsign *= -1;
  }

  cout << min(ac, bc) << "\n";

  return 0;
}