#include <algorithm>
#include <iostream>
#include <map>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long a, b, q;
  cin >> a >> b >> q;

  q %= 3;
  if (q == 1) {
    cout << a << "\n";
  } else if (q == 2) {
    cout << b << "\n";
  } else {
    cout << (a ^ b) << "\n";
  }

  return 0;
}