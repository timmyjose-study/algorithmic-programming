#include <algorithm>
#include <iostream>
#include <limits>

using namespace std;

int main() {
  int tt, n;
  int d;

  cin >> tt;
  while (tt--) {
    cin >> n;

    int mn = numeric_limits<int>::max(), mx = numeric_limits<int>::min();
    for (int i = 0; i < n; i++) {
      cin >> d;
      mn = min(mn, d);
      mx = max(mx, d);
    }

    cout << (mx - mn) << "\n";
  }

  return 0;
}