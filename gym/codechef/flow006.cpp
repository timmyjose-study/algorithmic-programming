#include <iostream>

using namespace std;

int main() {
  int tt, n;

  cin >> tt;
  while (tt--) {
    cin >> n;

    int s = 0;
    while (n) {
      s += n % 10;
      n /= 10;
     }

     cout << s << "\n";
  }

  return 0;
}