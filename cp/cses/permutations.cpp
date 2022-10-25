#include <iostream>
#include <set>
#include <vector>

using namespace std;

void permutations(const vector<int> &a, int curr_idx, int n, set<int> &visited,
                  vector<int> &curr_perm, vector<vector<int>> &perms) {
  if (curr_perm.size() == n) {
    perms.push_back(curr_perm);
    return;
  }

  if (curr_idx == n) {
    return;
  }

  for (int e : a) {
    if (visited.find(e) == visited.end()) {
      visited.insert(e);
      curr_perm.push_back(e);
      permutations(a, curr_idx + 1, n, visited, curr_perm, perms);
      visited.erase(e);
      curr_perm.pop_back();
    }
  }
}

vector<vector<int>> permutations(const vector<int> &a, int n) {
  vector<vector<int>> perms;
  set<int> visited;
  vector<int> curr_perm;
  permutations(a, 0, n, visited, curr_perm, perms);

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

  auto perms = permutations(a, n);
  for (auto perm : perms) {
    for (int p : perm) {
      cout << p << " ";
    }
    cout << "\n";
  }

  return 0;
}