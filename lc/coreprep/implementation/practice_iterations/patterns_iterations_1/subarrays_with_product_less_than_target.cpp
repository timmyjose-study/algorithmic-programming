#include <algorithm>
#include <iostream>
#include <list>
#include <vector>

using namespace std;

// O(n3) / O(n2)
vector<vector<int>> find_subarrays_smaller_product(vector<int> &a, int s) {
  int prod = 1, window_start = 0;
  vector<vector<int>> res;
  for (int window_end = 0; window_end < a.size(); window_end++) {
    prod *= a[window_end];

    while (prod >= s) {
      prod /= a[window_start];
      window_start++;
    }

    list<int> lst;
    for (int i = window_end; i >= window_start; i--) {
      lst.push_front(a[i]);
      vector<int> v(lst.begin(), lst.end());
      res.emplace_back(v);
    }
  }

  return res;
}

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

    auto res = find_subarrays_smaller_product(a, s);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}