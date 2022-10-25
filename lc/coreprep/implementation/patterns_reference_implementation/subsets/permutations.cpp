#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

// O(n x n!) / O(n x n!)
vector<vector<int>> permute(const vector<int> &a) {
  vector<vector<int>> all_perms;

  queue<vector<int>> q;
  q.push({});

  for (int e : a) {
    int n = q.size();

    for (int i = 0; i < n; i++) {
      auto curr_perm = q.front();
      q.pop();

      for (int j = 0; j <= curr_perm.size(); j++) {
        vector<int> new_perm = curr_perm;
        new_perm.insert(new_perm.begin() + j, e);

        if (new_perm.size() == a.size()) {
          all_perms.emplace_back(new_perm);
        } else {
          q.push(new_perm);
        }
      }
    }
  }

  return all_perms;
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

    auto res = permute(a);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}