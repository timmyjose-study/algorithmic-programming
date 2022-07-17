#include <iostream>

using namespace std;

int main() {
  int n, d, cnt = 0;

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> d;
    if (d < 0) {
      cnt++;
    }
  }

  cout << cnt << "\n";

  return 0;
}