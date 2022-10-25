#include <algorithm>
#include <iostream>
#include <set>
#include <vector>

using namespace std;

void perms(const vector<char> &a, int idx, int n, set<char> &visited,
           vector<char> &curr_perm, vector<vector<char>> &all_perms, int k) {
  if (curr_perm.size() == k) {
    all_perms.emplace_back(curr_perm);
    return;
  }

  if (idx == n) {
    return;
  }

  for (char c : a) {
    if (visited.find(c) == visited.end()) {
      visited.insert(c);
      curr_perm.push_back(c);
      perms(a, idx + 1, n, visited, curr_perm, all_perms, k);
      visited.erase(c);
      curr_perm.pop_back();
    }
  }
}

vector<vector<char>> perms(const vector<char> &a, int k) {
  vector<vector<char>> all_perms;
  vector<char> curr_perm;
  set<char> visited;
  perms(a, 0, a.size(), visited, curr_perm, all_perms, k);

  return all_perms;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto eval = [](long long x, long long y, long long z, const char op1,
                 const char op2) {
    switch (op1) {
    case '+':
      switch (op2) {
      case '-':
        return x + y - z;
      case '*':
        return x + y * z;
      }
    case '-':
      switch (op2) {
      case '+':
        return x - y + z;
      case '*':
        return x - y * z;
      }

    default:
      switch (op2) {
      case '+':
        return x * y + z;
      default:
        return x * y - z;
      }
    }
  };

  long long a, b, c, d;
  cin >> a >> b >> c >> d;

  vector<char> v = {'+', '-', '*'};
  auto all_perms = perms(v, 2);
  for (auto perm : all_perms) {
    if (eval(a, b, c, perm[0], perm[1]) == d) {
      cout << "YES\n";
      return 0;
    }
  }

  cout << "NO\n";

  return 0;
}