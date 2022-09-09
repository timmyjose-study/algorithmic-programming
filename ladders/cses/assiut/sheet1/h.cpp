#include <cmath>
#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m;

  cin >> n >> m;
  cout << "floor " << n << " / " << m << " = " << floor((double)n / m) << "\n";
  cout << "ceil " << n << " / " << m << " = " << ceil((double)n / m) << "\n";
  cout << "round " << n << " / " << m << " = " << round((double)n / m) << "\n";

  return 0;
}