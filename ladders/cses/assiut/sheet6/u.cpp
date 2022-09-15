#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  long x1, y1, x2, y2, x3, y3;
  cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;

  cout << (((y2 - y1) * (x3 - x2)) == ((x2 - x1) * (y3 - y2)) ? "YES" : "NO")
       << "\n";

  return 0;
}