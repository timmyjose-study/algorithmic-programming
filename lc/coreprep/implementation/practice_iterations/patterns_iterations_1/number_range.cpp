#include <algorithm>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

enum Pos { Min, Max };

int find_pos(const vector<int> &a, int low, int high, int k, Pos pos) {
  int last_pos = -1;
  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] < k) {
      low = mid + 1;
    } else if (a[mid] > k) {
      high = mid - 1;
    } else {
      last_pos = mid;

      if (pos == Min) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
  }

  return last_pos;
}

// O(logn) / O(1)
pair<int, int> find_range(const vector<int> &a, int k) {
  int min_pos = -1, max_pos = -1;

  min_pos = find_pos(a, 0, a.size() - 1, k, Pos::Min);
  max_pos = find_pos(a, 0, a.size() - 1, k, Pos::Max);

  return make_pair<>(min_pos, max_pos);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto [pos1, pos2] = find_range(a, k);
    cout << pos1 << " " << pos2 << "\n";
  }

  return 0;
}