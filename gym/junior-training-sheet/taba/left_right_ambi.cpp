#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  int l, r, a;

  cin >> l >> r >> a;

  while (a) {
    if (l < r) {
      l++;
    } else {
      r++;
    }
    a--;
  }

  cout << (min(l, r) * 2) << "\n";

  return 0;
}