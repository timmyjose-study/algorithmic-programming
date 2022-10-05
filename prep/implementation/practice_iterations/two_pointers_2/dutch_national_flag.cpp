#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void swap(vector<int> &a, int x, int y) {
  int t = a[x];
  a[x] = a[y];
  a[y] = t;
}

void sort(vector<int> &a, int low, int high) {
  int i = 0;

  while (i <= high) {
    if (a[i] == 0) {
      swap(a, i, low);
      i++;
      low++;
    } else if (a[i] == 1) {
      i++;
    } else {
      swap(a, i, high);
      high--;
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

    sort(a, 0, n - 1);

    for (int e : a) {
      cout << e << " ";
    }
    cout << "\n";
  }

  return 0;
}