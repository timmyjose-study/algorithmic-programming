#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  long long a, b, c, d;

  cin >> a >> b >> c >> d;
  cout << "Difference = " << (a * b - c * d) << "\n";

  return 0;
}