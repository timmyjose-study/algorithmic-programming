#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, e, p = 0, c = 0;

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> e;
    if (e == -1) {
      if (p > 0) {
        p--;
      } else {
        c++;
      }
    } else {
      p += e;
    }
  }

  cout << c << "\n";

  return 0;
}