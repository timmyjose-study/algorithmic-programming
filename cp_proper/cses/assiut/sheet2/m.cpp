#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto is_lucky = [](int n) {
    int d;
    while (n) {
      d = n % 10;
      if (d != 4 && d != 7) {
        return false;
      }
      n /= 10;
    }
    return true;
  };

  int f, t;
  cin >> f >> t;

  int lc = 0;
  for (int i = f; i <= t; i++) {
    if (is_lucky(i)) {
      lc++;
      cout << i << " ";
    }
  }

  if (!lc) {
    cout << -1;
  }
  cout << "\n";

  return 0;
}