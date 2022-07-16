#include <cmath>
#include <iostream>

using namespace std;

int main() {
  int tt, u, v, a, s;

  cin >> tt;
  while (tt--) {
    cin >> u >> v >> a >> s;

    int vv = (u * u - 2.0 * a * s);
    cout << (vv <= v * v ? "Yes\n" : "No\n");
  }

  return 0;
}