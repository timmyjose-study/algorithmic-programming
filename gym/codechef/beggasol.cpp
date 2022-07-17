#include <algorithm>
#include <array>
#include <iostream>

using namespace std;

const int N = 210;

int main() {
  int tt, n;
  array<int, N> a;

  cin >> tt;
  while (tt--) {
    cin >> n;
    a.fill(0);

    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    int fuel = a[0];
    int dist = 0;
    bool done = false;

    if (!fuel) {
      cout << dist << "\n";
      continue;
    }

    for (int i = 1; i < n; i++) {
      dist++;
      fuel = fuel - 1 + a[i];
      if (fuel == 0) {
        cout << dist << "\n";
        done = true;
        break;
      }
    }

    if (!done) {
      dist += fuel;
      cout << dist << "\n";
    }
  }

  return 0;
}