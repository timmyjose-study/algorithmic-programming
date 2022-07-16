#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, d, r;
  cin >> n;
  while (n--) {
    cin >> d;

    r = 0;
    while (d) {
      r = 10 * r + (d % 10);
      d /= 10;
     }
    cout << r << "\n";
  }

  return 0;
}
