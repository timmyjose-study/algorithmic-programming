#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  bool has_prev = false;
  for (int d = 2; d <= n / 2; d++) {
    int cnt = 0;
    while (n % d == 0) {
      cnt++;
      n /= d;
    }

    if (cnt > 0) {
      if (has_prev) {
        cout << "*";
      }

      has_prev = true;
      cout << "(" << d << "^" << cnt << ")";
    }

    if (n == 1) {
      break;
    }
  }

  if (n > 1) {
    if (has_prev) {
      cout << "*";
    }
    cout << "(" << n << "^1"
         << ")";
  }

  cout << "\n";

  return 0;
}