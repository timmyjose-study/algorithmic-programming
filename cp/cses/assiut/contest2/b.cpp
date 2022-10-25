#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  for (int i = 0; i < n; i++) {
    int bpos = i;
    int spos = n - i - 1;

    for (int j = 0; j < n; j++) {
      if (j == bpos && j != n / 2) {
        cout << '\\';
      } else if (i == n / 2 && j == n / 2) {
        cout << "X";
      } else if (j == spos && j != n / 2) {
        cout << "/";
      } else {
        cout << "*";
      }
    }
    cout << "\n";
  }

  return 0;
}