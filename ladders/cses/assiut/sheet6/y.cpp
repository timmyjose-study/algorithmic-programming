#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  cin >> tt;

  long long n, x1, y1, x2, y2;
  long long max_leftx, max_lefty, min_rightx, min_righty;

  for (int j = 1; j <= tt; j++) {
    cin >> n;

    cin >> x1 >> y1 >> x2 >> y2;
    max_leftx = x1;
    max_lefty = y1;
    min_rightx = x2;
    min_righty = y2;

    for (int i = 1; i < n; i++) {
      cin >> x1 >> y1 >> x2 >> y2;

      max_leftx = max(max_leftx, x1);
      max_lefty = max(max_lefty, y1);
      min_rightx = min(min_rightx, x2);
      min_righty = min(min_righty, y2);
    }

    int d1 = abs(min_rightx - max_leftx);
    int d2 = abs(min_righty - max_lefty);

    if (min_rightx > max_leftx && min_righty > max_lefty) {
      cout << "Case #" << j << ": " << (d1 * d2) << "\n ";
    } else {
      cout << 0 << "\n";
    }
  }

  return 0;
}