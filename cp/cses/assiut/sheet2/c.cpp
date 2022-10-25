#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, d, ne = 0, no = 0, np = 0, nn = 0;
  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> d;

    if (d < 0) {
      nn++;
    }

    if (d > 0) {
      np++;
    }

    if (d % 2 == 0) {
      ne++;
    } else {
      no++;
    }
  }

  cout << "Even: " << ne << "\n";
  cout << "Odd: " << no << "\n";
  cout << "Positive: " << np << "\n";
  cout << "Negative: " << nn << "\n";

  return 0;
}