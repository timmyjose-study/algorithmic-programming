#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n;

  cin >> n;

  while (true) {
    if (n == 1) {
      cout << n << "\n";
      break;
    }

    cout << n;

    if (n % 2 == 0) {
      n /= 2;
    } else {
      n = 3 * n + 1;
    }
    cout << " ";
  }

  return 0;
}