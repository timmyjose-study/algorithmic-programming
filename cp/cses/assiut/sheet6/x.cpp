#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

const double EPS = 1e-9;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto lt = [&](double s, double t) { return s <= t + EPS; };

  auto gt = [&](double s, double t) { return s + EPS >= t; };

  auto check = [&](double xmin, double ymin, double xmax, double ymax, double x,
                   double y) {
    return gt(x, xmin) && lt(x, xmax) && gt(y, ymin) && lt(y, ymax);
  };

  int n;
  double x1, y1, x2, y2, x3, y3, x4, y4;
  double x, y;
  cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3 >> x4 >> y4;

  double xmin = min(min(x1, x2), min(x3, x4));
  double xmax = max(max(x1, x2), max(x3, x4));
  double ymin = min(min(y1, y2), min(y3, y4));
  double ymax = max(max(y1, y2), max(y3, y4));

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x >> y;
    cout << (check(xmin, ymin, xmax, ymax, x, y) ? "YES" : "NO") << "\n";
  }

  return 0;
}