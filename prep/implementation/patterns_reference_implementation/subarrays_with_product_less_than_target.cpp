#include <algorithm>
#include <iostream>
#include <list>
#include <vector>

using namespace std;

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
    int window_start = 0;
    int product = 1;

    for (int window_end = 0; window_end < n; window_end++) {
      product *= a[window_end];

      while (product >= s && window_start < n) {
        product /= a[window_start++];
      }

      list<int> tmp;
      for (int i = window_end; i >= window_start; i--) {
        tmp.push_front(a[i]);
        vector<int> sub(tmp.begin(), tmp.end());
        res.push_back(sub);
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