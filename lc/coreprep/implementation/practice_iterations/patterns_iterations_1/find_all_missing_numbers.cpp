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
vector<int> find_all_missing_numbers(vector<int> &a) {
  int i = 0;
  while (i < a.size()) {
    if (a[i] != a[a[i] - 1]) {
      swap(a, i, a[i] - 1);
    } else {
      i++;
    }
  }

  vector<int> res;
  for (int i = 0; i < a.size(); i++) {
    if (i != a[i] - 1) {
      res.push_back(i + 1);
    }
  }

  return res;
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

    auto res = find_all_missing_numbers(a);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}