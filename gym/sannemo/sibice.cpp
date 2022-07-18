#include <cmath>
#include <iostream>

using namespace std;

int main() {
  int n, w, h;

  cin >> n >> w >> h;

  int d = sqrt(w * w + h * h);
  int l;

  for (int i = 0; i < n; i++) {
    cin >> l;
    if (l <= w || l <= h || l <= d) {
      cout << "DA\n";
    } else {
      cout << "NE\n";
    }
  }

  return 0;
}