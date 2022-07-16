#include <iostream>

using namespace std;

int main() {
  int tt, a, b, x;

  cin >> tt;
  while (tt--) {
    cin >> a >> b >> x;
    cout << ((b - a) / x) << "\n";
  }

  return 0;
}