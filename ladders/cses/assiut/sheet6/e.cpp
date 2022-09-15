#include <cmath>
#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n;
  cin >> n;

  long long r = round(sqrt(2 * n));
  while (r) {
    if (r * (r + 1) <= 2 * n) {
      break;
    }
    r--;
  }

  cout << r << "\n";

  return 0;
}