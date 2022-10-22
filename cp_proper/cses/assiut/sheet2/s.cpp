#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, a, b, s;
  cin >> tt;

  while (tt--) {
    cin >> a >> b;

    if (a > b) {
      int t = a;
      a = b;
      b = t;
    }

    s = 0;
    for (int i = a + 1; i < b; i++) {
      if (i % 2) {
        s += i;
      }
    }
    cout << s << "\n";
  }

  return 0;
}