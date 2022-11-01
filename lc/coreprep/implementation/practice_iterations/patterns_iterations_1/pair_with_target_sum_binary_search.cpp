#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int binary_search(const vector<int> &a, int low, int high, int elem) {
  int mid = -1;

  while (low <= high) {
    mid = low + (high - low) / 2;

    if (a[mid] == elem) {
      return mid;
    } else if (a[mid] < elem) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }

  return -1;
}

// O(nlogn) / O(1)
pair<int, int> pair_with_sum(const vector<int> &a, int s) {
  int lpos = -1, rpos = -1, idx = -1;

  for (int i = 0; i < a.size(); i++) {
    idx = binary_search(a, 0, a.size() - 1, s - a[i]);
    if (idx != -1) {
      lpos = i;
      rpos = idx;
      break;
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