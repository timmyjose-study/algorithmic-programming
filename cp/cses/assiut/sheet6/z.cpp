#include <cmath>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

const double EPS = 1e-9;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto gt = [](double s, double t) { return s >= t + EPS; };

  double r, s;
  cin >> r >> s;

  if (gt(s, 2.0 * r)) {
    cout << "Square\n";
  } else if (gt(sqrt(2) * r, s)) {
    cout << "Circle\n";
  } else {
    cout << "Complex\n";
  }

  return 0;
}