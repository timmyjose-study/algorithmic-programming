#include <iostream>

using namespace std;

int main() {
  int tt, n, x, s, r;

  cin >> tt;
  while (tt--) {
    cin >> n >> x;
    int mx = -1;

    for (int i = 0; i < n; i++) {
      cin >> s >> r;
      if (s <= x && r > mx) {
        mx = r;
      }
    }

    cout << mx << "\n";
  }

  return 0;
}