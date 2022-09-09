#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m;

  while (cin >> n >> m) {
    if (n <= -0 || m <= 0) {
      break;
    }

    int s = 0;
    if (n > m) {
      int t = n;
      n = m;
      m = t;
    }

    for (int i = n; i <= m; i++) {
      cout << i << " ";
      s += i;
    }

    cout << "sum =" << s << "\n";
  }

  return 0;
}