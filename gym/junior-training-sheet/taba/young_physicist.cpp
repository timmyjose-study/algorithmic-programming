#include <iostream>

using namespace std;

int main() {
  int n, x = 0, y = 0, z = 0, d = 0;

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> d;
    x += d;

    cin >> d;
    y += d;

    cin >> d;
    z += d;
  }

  if (!x && !y && !z) {
    cout << "YES\n";
  } else {
    cout << "NO\n";
  }

  return 0;
}