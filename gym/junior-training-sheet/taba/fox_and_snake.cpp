#include <iostream>

using namespace std;

int main() {
  int n, m;
  cin >> n >> m;

  bool l2r = true;
  for (int i = 0; i < n; i++) {
    if (i % 2 == 0) {
      for (int j = 0; j < m; j++) {
        cout << '#';
      }
      cout << "\n";
    } else {
      if (l2r) {
        for (int j = 0; j < m - 1; j++) {
          cout << '.';
        }
        cout << '#' << "\n";
        l2r = false;
      } else {
        cout << '#';
        for (int j = 0; j < m - 1; j++) {
          cout << '.';
        }
        cout << "\n";
        l2r = true;
      }
    }
  }

  return 0;
}