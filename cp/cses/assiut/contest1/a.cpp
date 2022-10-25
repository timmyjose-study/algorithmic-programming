#include <iomanip>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int x, n;
  cin >> x >> n;

  double p = (100.0 * (double)n) / (100.0 - x);
  cout << fixed << setprecision(2) << p << "\n";

  return 0;
}