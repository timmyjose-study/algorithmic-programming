#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, x, y, z;
 
  cin >> tt;
  while (tt--) {
    cin >> x >> y >> z;
    cout << (x + y + z == 180 ? "YES" : "NO") << endl;
  }

  return 0;
}