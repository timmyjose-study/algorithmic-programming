#include <algorithm>
#include <iostream>
#include <set>
#include <vector>

using namespace std;

void combine(const vector<int> &a, int curr_idx, int n, vector<int> &curr_comb,
             vector<vector<int>> &combs, int k) {
  if (curr_comb.size() == k) {
    combs.push_back(curr_comb);
    return;
  }

  if (curr_idx == n) {
    return;
  }

  curr_comb.push_back(a[curr_idx]);
  combine(a, curr_idx + 1, n, curr_comb, combs, k);
  curr_comb.pop_back();
  combine(a, curr_idx + 1, n, curr_comb, combs, k);
}

vector<vector<int>> combine(const vector<int> &a, int n, int k) {
  vector<vector<int>> combs;
  vector<int> curr_comb;
  combine(a, 0, n, curr_comb, combs, k);

  return combs;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, k;
  cin >> n >> k;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  auto combs = combine(a, n, k);
  for (auto comb : combs) {
    for (auto c : comb) {
      cout << c << " ";
    }
    cout << "\n";
  }

  return 0;
}