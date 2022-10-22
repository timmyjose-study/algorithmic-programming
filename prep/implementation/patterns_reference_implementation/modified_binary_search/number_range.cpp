#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

enum FindPos { MinPos, MaxPos };

int binary_search(const vector<int> &a, int low, int high, int k,
                  FindPos find) {
  int kpos = -1;

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] < k) {
      low = mid + 1;
    } else if (a[mid] > k) {
      high = mid - 1;
    } else {
      kpos = mid;

      if (find == MinPos) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
  }

  return kpos;
}

// O(logn) / O(1)
pair<int, int> find_min_max_pos(const vector<int> &a, int low, int high,
                                int k) {
  int min_pos = -1, max_pos = -1;

  min_pos = binary_search(a, low, high, k, MinPos);
  max_pos = binary_search(a, low, high, k, MaxPos);

  return make_pair(min_pos, max_pos);
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

    auto [min_pos, max_pos] = find_min_max_pos(a, 0, n - 1, k);
    cout << min_pos << " " << max_pos << "\n";
  }

  return 0;
}