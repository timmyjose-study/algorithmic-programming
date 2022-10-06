#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void swap(vector<int> &a, int x, int y) {
  int t = a[x];
  a[x] = a[y];
  a[y] = t;
}

void sort(vector<int> &a) {
  int i = 0;

  while (i < a.size()) {
    if (a[i] != a[a[i] - 1]) {
      swap(a, i, a[i] - 1);
    } else {
      i++;
    }
  }
}

// O(n) / O(1)
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

    vector<int> res;
    for (int i = 0; i < n; i++) {
      if (a[i] != i + 1) {
        res.add(a[i]);
      }
    }

    for (int d : res) {
      cout << d << " ";
    }
    cout << "\n";
  }

  return 0;
}