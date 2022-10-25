#include <cmath>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

const double EPS = 1e-9;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto dist = [](double x1, double y1, double x2, double y2) {
    return sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
  };

  double x1, y1, x2, y2, x3, y3, x4, y4;
  cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3 >> x4 >> y4;

  double c1x = (x1 + x2) / 2.0;
  double c1y = (y1 + y2) / 2.0;
  double c1r = dist(x1, y1, c1x, c1y);

  double c2x = (x3 + x4) / 2.0;
  double c2y = (y3 + y4) / 2.0;
  double c2r = dist(x3, y3, c2x, c2y);

  double dcentres = dist(c1x, c1y, c2x, c2y);

  if (dcentres <= c1r + c2r + EPS) {
    cout << "YES\n";
  } else {
    cout << "NO\n";
  }

  return 0;
}