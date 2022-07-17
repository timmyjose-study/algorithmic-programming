#include <iomanip>
#include <iostream>

using namespace std;

int main() {
  double r, c;

  cin >> r >> c;

  double percentage = (r - c) * (r - c) / (r * r) * 100.0;
  cout << fixed << setprecision(7) << percentage << endl;

  return 0;
}