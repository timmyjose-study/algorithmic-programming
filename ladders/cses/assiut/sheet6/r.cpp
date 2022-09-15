#include <cmath>
#include <iomanip>
#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  double x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;

  double d = sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
  cout << fixed << setprecision(9) << d << "\n";

  return 0;
}