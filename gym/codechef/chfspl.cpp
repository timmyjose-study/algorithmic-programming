#include <algorithm>
#include <array>
#include <iostream>

using namespace std;

int main() {
  int tt, d;
  array<int, 3> a;

  cin >> tt;
  while (tt--) {
    cin >> a[0] >> a[1] >> a[2];
    sort(a.begin(), a.end());
    cout << (a[1] + a[2]) << endl;
  }

  return 0;
}