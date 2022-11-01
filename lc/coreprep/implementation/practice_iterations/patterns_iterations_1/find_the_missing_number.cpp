#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void swap(vector<int> &a, int x, int y) {
  int t = a[x];
  a[x] = a[y];
  a[y] = t;
}

// O(n) / O(1)
int missing_number(vector<int> &a) {
  int i = 0;

  while (i < a.size()) {
    if (a[i] < a.size() && (a[i] != a[a[i]])) {
      swap(a, i, a[i]);
    } else {
      i++;
    }
  }

  for (int i = 0; i < a.size(); i++) {
    if (a[i] != i) {
      return i;
    }
  }

  return -1;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n - 1);
    for (int i = 0; i < n - 1; i++) {
      cin >> a[i];
    }

    cout << missing_number(a) << "\n";
  }

  return 0;
}