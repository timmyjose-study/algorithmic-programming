#include <iostream>

using namespace std;

int main() {
  int x, y, z;

  cin >> x >> y >> z;
  cout << min(abs(x - y) + abs(x - z),
              min(abs(x - y) + abs(y - z), abs(x - z) + abs(y - z)))
       << "\n";

  return 0;
}