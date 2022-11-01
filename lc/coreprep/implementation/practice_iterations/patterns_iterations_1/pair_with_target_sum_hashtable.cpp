#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

// O(n) / O(n)
pair<int, int> pair_with_target_sum(const vector<int> &a, int s) {
  unordered_map<int, int> pos;
  int lpos = -1, rpos = -1;

  for (int i = 0; i < a.size(); i++) {
    if (pos.find(s - a[i]) != pos.end()) {
      lpos = i;
      rpos = pos[s - a[i]];
      break;
    }
    pos[a[i]] = i;
  }

  return make_pair<>(lpos, rpos);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, s;
  cin >> tt;

  while (tt--) {
    cin >> n >> s;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto [pos1, pos2] = pair_with_target_sum(a, s);
    cout << pos1 << " " << pos2 << "\n";
  }

  return 0;
}