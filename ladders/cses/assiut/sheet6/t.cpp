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
    return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
  };

  double x, y, r, n;
  double x1, y1;
  cin >> x >> y >> r >> n;

  for (int i = 0; i < n; i++) {
    cin >> x1 >> y1;
    if (dist(x, y, x1, y1) <= r + EPS) {
      cout << "YES\n";
    } else {
      cout << "NO\n";
    }
  }

  return 0;
}