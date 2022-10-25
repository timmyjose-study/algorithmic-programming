#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    if (!n) {
      cout << n << "\n";
      continue;
    }

    while (n) {
      cout << (n % 10) << " ";
      n /= 10;
    }
    cout << "\n";
  }

  return 0;
}