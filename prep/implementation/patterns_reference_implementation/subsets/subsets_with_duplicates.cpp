#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(2^n) / O(2^n)
vector<vector<int>> subsets_with_duplicates(vector<int> &a) {
  sort(a.begin(), a.end());

  vector<vector<int>> all_subs;
  all_subs.push_back({});

  int start = 0;

  for (int i = 0; i < a.size(); i++) {
    int n = all_subs.size();
    int curr_start = (i > 0 && (a[i] == a[i - 1])) ? start : 0;
    for (int j = curr_start; j < n; j++) {
      vector<int> curr_sub = all_subs[j];
      curr_sub.push_back(a[i]);
      all_subs.emplace_back(curr_sub);
    }
    start = n;
  }

  return all_subs;
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

    auto res = subsets_with_duplicates(a);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}