#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, d;

  cin >> n;

  while (true) {
    d = n % 10;
    n /= 10;

    if (!n) {
      cout << (d % 2 == 0 ? "EVEN" : "ODD") << "\n";
      break;
    }
  }

  return 0;
}