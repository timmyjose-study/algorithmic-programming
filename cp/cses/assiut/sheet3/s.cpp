#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m, d, k;
  cin >> n >> m;

  vector<vector<int>> a;
  for (int i = 0; i < n; i++) {
    vector<int> v;
    for (int j = 0; j < m; j++) {
      cin >> d;
      v.emplace_back(d);
    }
    a.emplace_back(v);
  }

  cin >> k;

  for (auto r : a) {
    for (int c : r) {
      if (c == k) {
        cout << "will not take number\n";
        return 0;
      }
    }
  }

  cout << "will take number\n";

  return 0;
}