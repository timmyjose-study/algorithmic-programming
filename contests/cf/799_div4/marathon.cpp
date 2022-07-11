#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int main() {
  int tt, a, b, c, d;

  cin >> tt;
  while (tt--) {
    cin >> a >> b >> c >> d;

    int sol = 0;

    if (a < b) {
      sol++;
    }

    if (a < c) {
      sol++;
    }

    if (a < d) {
      sol++;
    }

    cout << sol << "\n";
  }

  return 0;
}