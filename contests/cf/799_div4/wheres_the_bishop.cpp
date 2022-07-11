#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int main() {
  int tt;
  char a[8][8];

  cin >> tt;
  while (tt--) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        cin >> a[i][j];
      }
    }

    bool v = false;
    for (int i = 1; i < 7; i++) {
      for (int j = 1; j < 7; j++) {
        if ((a[i - 1][j - 1] == '#') && (a[i - 1][j + 1] == '#') &&
            (a[i + 1][j + 1] == '#') && (a[i + 1][j - 1] == '#')) {
          cout << (i + 1) << " " << (j + 1) << "\n";
          v = true;
          break;
        }
      }

      if (v) {
        break;
      }
    }

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        a[i][j] = '.';
      }
    }
  }

  return 0;
}