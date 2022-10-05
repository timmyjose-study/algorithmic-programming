#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void permute(const vector<int> &a, int curr_idx, int n, vector<bool> &visited,
             vector<int> &curr_perm, vector<vector<int>> &perms) {
  if (curr_perm.size() == n) {
    perms.push_back(curr_perm);
    return;
  }

  if (curr_idx == n) {
    return;
  }

  for (int i = 0; i < n; i++) {
    if (visited[i]) {
      continue;
    }

    if (i > 0 && (a[i] == a[i - 1]) && visited[i - 1]) {
      continue;
    }

    visited[i] = true;
    curr_perm.push_back(a[i]);
    permute(a, curr_idx + 1, n, visited, curr_perm, perms);
    visited[i] = false;
    curr_perm.pop_back();
    permute(a, curr_idx + 1, n, visited, curr_perm, perms);
  }
}

vector<vector<int>> permute(vector<int> &a) {
  sort(a.begin(), a.end());

  vector<vector<int>> perms;
  vector<int> curr_perm;
  vector<bool> visited(a.size(), false);

  permute(a, 0, a.size(), visited, curr_perm, perms);
  return perms;
}

// O(n! * n) / O(n! * n)
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

    auto perms = permute(a);
    for (auto perm : perms) {
      for (int p : perm) {
        cout << p << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}