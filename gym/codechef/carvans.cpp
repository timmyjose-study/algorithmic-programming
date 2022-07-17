#include <algorithm>
#include <array>
#include <iostream>

using namespace std;

const int N = 10100;

int main() {
  int tt, n;
  array<int, N> a;

  auto Check = [&](int idx) {
    for (int i = idx - 1; i >= 0; i--) {
      if (a[i] < a[idx]) {
        return false;
      }
    }
    return true;
  };

  cin >> tt;
  while (tt--) {
    cin >> n;

    a.fill(0);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    int num_max = 1;
    for (int i = 1; i < n; i++) {
      if (Check(i)) {
        num_max++;
      }
    }

    cout << num_max << "\n";
  }

  return 0;
}