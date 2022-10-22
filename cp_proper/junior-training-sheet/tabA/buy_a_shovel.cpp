#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int k, r;
  int m = 1;

  cin >> k >> r;

  while (true) {
    if (m * k % 10 == 0) {
      break;
    }

    if ((m * k - r) % 10 == 0) {
      break;
    }
    m++;
  }

  cout << m << "\n";

  return 0;
}