#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int a, b, c, x, y, z;
  cin >> a >> b >> c;

  x = a;
  y = b;
  z = c;

  if (a <= b) {
    if (a <= c) {
      cout << a << "\n";
      if (b <= c) {
        cout << b << "\n" << c << "\n";
      } else {
        cout << c << "\n" << b << "\n";
      }
    } else {
      cout << c << "\n" << a << "\n" << b << "\n";
    }
  } else if (b <= c) {
    if (c <= a) {
      cout << b << "\n" << c << "\n" << a << "\n";
    } else {
      cout << b << "\n" << a << "\n" << c << "\n";
    }
  } else {
    cout << c << "\n" << b << "\n" << a << "\n";
  }
  cout << "\n";

  cout << x << "\n";
  cout << y << "\n";
  cout << z << "\n";

  return 0;
}