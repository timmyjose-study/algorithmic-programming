#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void swap(vector<int> &a, int x, int y) {
  int t = a[x];
  a[x] = a[y];
  a[y] = t;
}

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

    int i = 0;
    int duplicate = -1;
    while (i < a.size()) {
      if (a[i] != i + 1) {
        if (a[i] != a[a[i] - 1]) {
          swap(a, i, a[i] - 1);
        } else {
          duplicate = a[i];
          break;
        }
      } else {
        i++;
      }
    }

    cout << duplicate << "\n";
  }

  return 0;
}