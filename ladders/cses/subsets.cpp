#include <iostream>
#include <vector>

using namespace std;

void subsets(const vector<int> &a, int curr_idx, int n, vector<int> &curr_sub,
             vector<vector<int>> &subs) {
  if (curr_idx == n) {
    subs.push_back(curr_sub);
  } else {
    curr_sub.push_back(a[curr_idx]);
    subsets(a, curr_idx + 1, n, curr_sub, subs);
    curr_sub.pop_back();
    subsets(a, curr_idx + 1, n, curr_sub, subs);
  }
}

vector<vector<int>> subsets(const vector<int> &a, int n) {
  vector<vector<int>> subs;
  vector<int> curr_sub;
  subsets(a, 0, n, curr_sub, subs);

  return subs;
}

const vector<vector<int>> subsets_bitmask(const vector<int> &a, int n) {
  vector<vector<int>> subs;

  for (int i = 0; i < (1 << n); i++) {
    vector<int> curr_sub;
    for (int j = 0; j < n; j++) {
      if (i & (1 << j)) {
        curr_sub.push_back(a[j]);
      }
    }
    subs.push_back(curr_sub);
  }

  return subs;
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

  auto subs = subsets(a, n);

  for (auto sub : subs) {
    for (int s : sub) {
      cout << s << " ";
    }
    cout << "\n";
  }

  subs = subsets_bitmask(a, n);
  for (auto sub : subs) {
    for (int s : sub) {
      cout << s << " ";
    }
    cout << "\n";
  }

  return 0;
}