#include <algorithm>
#include <iostream>
#include <set>
#include <vector>

using namespace std;

void permute(vector<int> &a, vector<bool> &visited, vector<int> &curr_perm,
             vector<vector<int>> &perms) {
  if (curr_perm.size() == a.size()) {
    perms.push_back(curr_perm);
    return;
  }

  for (int i = 0; i < a.size(); i++) {
    if (visited[i]) {
      continue;
    }

    if (i > 0 && a[i] == a[i - 1] && !visited[i - 1]) {
      continue;
    }

    visited[i] = true;
    curr_perm.push_back(a[i]);
    permute(a, visited, curr_perm, perms);
    visited[i] = false;
    curr_perm.pop_back();
  }
}

vector<vector<int>> permute(vector<int> &a) {
  vector<vector<int>> perms;
  vector<int> curr_perm;

  vector<bool> visited(a.size());
  fill(visited.begin(), visited.end(), false);

  permute(a, visited, curr_perm, perms);

  return perms;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  sort(a.begin(), a.end());

  auto perms = permute(a);
  for (auto perm : perms) {
    for (int p : perm) {
      cout << p << " ";
    }
    cout << "\n";
  }

  return 0;
}