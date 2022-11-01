#include <algorithm>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

// O(n x n!) / O(n x n!)
vector<vector<int>> permutations(const vector<int> &a) {
  vector<vector<int>> res;

  queue<vector<int>> q;
  q.push(vector<int>{});

  for (int e : a) {
    int n = q.size();

    for (int i = 0; i < n; i++) {
      vector<int> curr_perm = q.front();
      q.pop();

      for (int i = 0; i <= curr_perm.size(); i++) {
        vector<int> new_perm = curr_perm;
        new_perm.insert(new_perm.begin() + i, e);

        if (new_perm.size() == a.size()) {
          res.push_back(new_perm);
        } else {
          q.push(new_perm);
        }
      }
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

    auto res = permutations(a);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}