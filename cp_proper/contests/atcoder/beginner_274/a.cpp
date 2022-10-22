#include <algorithm>
#include <iomanip>
#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int a, b;
  cin >> a >> b;

  double res = (double)b / (double)a;
  cout << fixed << setprecision(3) << res << "\n";

  return 0;
}