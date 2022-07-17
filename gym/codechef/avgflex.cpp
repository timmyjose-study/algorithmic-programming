#include <array>
#include <iostream>

using namespace std;

const int N = 110;

int main() {
  int tt, n;
  array<int, N> a;

  cin >> tt;
  while (tt--) {
    cin >> n;

    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    int boast = 0;
    for (int i = 0; i < n; i++) {
      int less = 0;
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        if (a[j] <= a[i]) {
          less++;
        }
      }

      if (less >= n - less - 1) {
        boast++;
      }
    }

    cout << boast << "\n";
  }

  return 0;
}