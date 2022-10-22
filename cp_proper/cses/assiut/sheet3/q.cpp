#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < n - i + 1; j++) {
        bool valid = true;
        for (int k = i; k < i + j; k++) {
          if (k < i + j - 1 && a[k] > a[k + 1]) {
            valid = false;
            break;
          }
        }

        if (valid) {
          cnt++;
        }
      }
    }

    cout << cnt << "\n";
  }

  return 0;
}