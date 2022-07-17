#include <cmath>
#include <iomanip>
#include <iostream>

using namespace std;

int main() {
  double r;

  cin >> r;
  cout << fixed << setprecision(6) << (M_PI * r * r) << endl
       << (2.0 * r * r) << endl;

  return 0;
}