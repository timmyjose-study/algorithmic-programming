#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, d;
  vector<int> a;
  cin >> tt;

  while (tt--) {
    cin >> n;
    for (int i = 0; i < n; i++) {
      cin >> d;
      a.emplace_back(d);
    }

    int min_val = (int)1e9 + 7;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (a[i] + a[j] + j - i < min_val) {
          min_val = a[i] + a[j] + j - i;
        }
      }
    }

    cout << min_val << "\n";
  }

  return 0;
}