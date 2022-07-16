#include <iostream>

using namespace std;

int main() {
  int tt, s, a, b, c;

  cin >> tt;
  while (tt--) {
    cin >> s >> a >> b >> c;

    double dc = s + (c * s) / 100.0;
    int nc = (int)dc;
    cout << (nc >= a && nc <= b ? "Yes\n" : "No\n");
  }

  return 0;
}