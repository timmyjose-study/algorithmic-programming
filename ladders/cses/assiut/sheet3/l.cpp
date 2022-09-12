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

    for (int i = 0; i < n; i++) {
      for (int c = 1; c <= n; c++) {
        int max_val = -(int)1e9 + 7;
        for (int j = i; j < c; j++) {
          max_val = max(max_val, a[j]);
        }
        if (max_val != -(int)1e9 + 7) {
          cout << max_val << " ";
        }
      }
    }
    cout << "\n";
  }

  return 0;
}