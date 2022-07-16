#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
  int tt, n;
  vector<int> a;

  cin >> tt;
  while (tt--) {
    cin >> n;

    for (int i = 0; i < n; i++) {
      a.push_back(i + 1);
    }

    for (int i = 1; i < n; i++) {
      a[i] += a[i - 1];
    }

    int mx = 0;
    for (int i = 0; i < n; i++) {
      int m = 0, s = 0;
      for (int j = n - 1; j >= 0; j--) {
        s = (i == 0 ? a[j] : a[j] - a[i - 1]);
        if (s % 2 == 0) {
          m = j - i + 1;
          break;
        }
      }
      mx = max(mx, m);
    }

    cout << mx << "\n";
    a.clear();
  }

  return 0;
}