#include <iomanip>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

const double PI = 3.141592653;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  double r;

  cin >> r;
  cout << fixed << setprecision(9) << (PI * r * r) << "\n";

  return 0;
}