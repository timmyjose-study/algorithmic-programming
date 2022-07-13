#include <algorithm>
#include <cmath>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int main() {
  int tt, n;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> n;
    cin >> s;

    int d = 0;
    for (char c : s) {
      switch (c) {
      case '0':
        d = (d + 1) % 4;
        break;
      case '1':
        d = (d + 3) % 4;
      }
    }

    switch (d) {
    case 0:
      cout << "E"
           << "\n";
      break;
    case 1:
      cout << "S"
           << "\n";
      break;
    case 2:
      cout << "W"
           << "\n";
      break;
    case 3:
      cout << "N"
           << "\n";
    }
  }

  return 0;
}