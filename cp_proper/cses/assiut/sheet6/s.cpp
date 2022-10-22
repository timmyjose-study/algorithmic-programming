#include <cmath>
#include <iomanip>
#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int a, b, c;
  cin >> a >> b >> c;

  if ((a + b > c) && (b + c > a) && (a + c > b)) {
    cout << "Valid\n";
    double s = (double)(a + b + c) / 2;
    double area = sqrt(s * (s - a) * (s - b) * (s - c));
    cout << fixed << setprecision(6) << area << "\n";
  } else {
    cout << "Invalid\n";
  }

  return 0;
}