#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, b, d;

  cin >> n >> b >> d;

  int s, w = 0, sol = 0;
  for (int i = 0; i < n; i++) {
    cin >> s;

    if (s <= b) {
      w += s;
    }

    if (w > d) {
      sol++;
      w = 0;
    }
  }

  cout << sol << "\n";

  return 0;
}