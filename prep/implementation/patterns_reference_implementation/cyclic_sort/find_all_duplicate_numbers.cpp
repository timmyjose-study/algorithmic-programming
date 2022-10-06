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
    vector<int> res;

    while (i < a.size()) {
      if (a[i] != a[a[i] - 1]) {
        swap(a, i, a[i] - 1);
      } else {
        i++;
      }
    }

    for (int i = 0; i < a.size(); i++) {
      if (a[i] != i + 1) {
        res.push_back(a[i]);
      }
    }

    for (int d : res) {
      cout << d << " ";
    }
    cout << "\n";
  }

  return 0;
}