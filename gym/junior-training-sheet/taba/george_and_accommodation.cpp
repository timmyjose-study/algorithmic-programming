#include <iostream>

using namespace std;

int main() {
  int n, p, q, cnt = 0;

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> p >> q;

    if (p + 2 <= q) {
      cnt++;
    }
  }

  cout << cnt << "\n";

  return 0;
}