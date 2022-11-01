#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n) / O(1)
pair<int, int> pair_with_sum(const vector<int> &a, int s) {
  int lpos = -1, rpos = -1;
  int left = 0, right = a.size() - 1;
  int sum = 0;

  while (left < right) {
    sum = a[left] + a[right];

    if (sum == s) {
      lpos = left;
      rpos = right;
      break;
    } else if (sum < s) {
      left++;
    } else {
      right--;
    }
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

    auto [pos1, pos2] = pair_with_sum(a, s);
    cout << pos1 << " " << pos2 << "\n";
  }

  return 0;
}