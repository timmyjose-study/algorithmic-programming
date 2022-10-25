#include <cmath>
#include <iostream>

using namespace std;

const double EPS = 1e-9;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto in_range = [](double x, double l, double r, bool first = false) {
    if (first) {
      return (l + EPS <= x && x <= r + EPS);
    }
    return (l + EPS < x && x <= r + EPS);
  };

  double d;
  cin >> d;

  if (in_range(d, 0.0, 25.0, true)) {
    cout << "Interval [0,25]"
         << "\n";
  } else if (in_range(d, 25.0, 50.0)) {
    cout << "Interval (25,50]"
         << "\n";
  } else if (in_range(d, 50.0, 75.0)) {
    cout << "Interval (50,75]"
         << "\n";
  } else if (in_range(d, 75.0, 100.0)) {
    cout << "Interval (75,100]"
         << "\n";
  } else {
    cout << "Out of Intervals"
         << "\n";
  }

  return 0;
}