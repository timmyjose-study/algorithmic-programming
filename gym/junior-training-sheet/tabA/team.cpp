#include <iostream>

using namespace std;

int main() {
  int n;
  int a, b, c;
  int sol = 0;

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a >> b >> c;

    if (a + b + c >= 2) {
      sol++;
    }
  }

  cout << sol << "\n";

  return 0;
}