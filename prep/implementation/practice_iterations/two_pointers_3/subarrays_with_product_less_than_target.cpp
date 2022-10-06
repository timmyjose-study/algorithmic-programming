#include <algorithm>
#include <iostream>
#include <list>
#include <vector>

using namespace std;

// O(n3) / O(n2)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, s;
  cin >> tt;

  while (tt--) {
    cin >> n >> s;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    vector<vector<int>> res;
    int product = 1;
    int window_start = 0;

    for (int window_end = 0; window_end < n; window_end++) {
      product *= a[window_end];

      while (product >= s) {
        product /= a[window_start];
        window_start++;
      }

      list<int> lst;
      for (int i = window_end; i >= window_start; i--) {
        lst.push_front(a[i]);

        vector<int> v(lst.begin(), lst.end());
        res.push_back(v);
      }
    }

    for (auto sub : res) {
      for (int e : sub) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}