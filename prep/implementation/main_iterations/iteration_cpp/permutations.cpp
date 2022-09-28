#include <algorithm>
#include <iostream>
#include <set>
#include <vector>

using namespace std;

void permute(const vector<int> &a, int n, set<int> &visited,
             vector<int> &curr_perm, vector<vector<int>> &perms) {
  if (curr_perm.size() == n) {
    perms.push_back(curr_perm);
    return;
  }

  for (int e : a) {
    if (visited.find(e) == visited.end()) {
      visited.insert(e);
      curr_perm.push_back(e);
      permute(a, n, visited, curr_perm, perms);
      visited.erase(e);
      curr_perm.pop_back();
    }
  }
}

vector<vector<int>> permute(const vector<int> &a, int n) {
  vector<vector<int>> perms;
  vector<int> curr_perm;
  set<int> visited;

  permute(a, n, visited, curr_perm, perms);

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

  auto perms = permute(a, n);
  for (auto perm : perms) {
    for (auto e : perm) {
      cout << e << " ";
    }
    cout << "\n";
  }

  return 0;
}