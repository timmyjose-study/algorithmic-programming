#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n) / O(1)
vector<int> sort(const vector<int> &a) {
  int n = a.size();

  vector<int> res(n);

  int left = 0, right = n - 1;
  int next_pos = n - 1;

  while (left < right) {
    int lval = a[left] * a[left];
    int rval = a[right] * a[right];

    if (lval >= rval) {
      res[next_pos--] = lval;
      left++;
    } else {
      res[next_pos--] = rval;
      right--;
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

    auto res = sort(a);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}