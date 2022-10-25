#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

enum FindPos {
  FindMin,
  FindMax,
};

int binary_search(const vector<int> &a, int low, int high, int k,
                  FindPos find) {
  int last_found_pos = -1;

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] < k) {
      low = mid + 1;
    } else if (a[mid] > k) {
      high = mid - 1;
    } else {
      last_found_pos = mid;

      if (find == FindMin) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
  }

  return last_found_pos;
}

// O(long) / O(1)
pair<int, int> find_number_range(const vector<int> &a, int low, int high,
                                 int k) {
  int first_pos = -1, last_pos = -1;

  first_pos = binary_search(a, low, high, k, FindMin);
  last_pos = binary_search(a, low, high, k, FindMax);

  return make_pair<>(first_pos, last_pos);
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

    auto [first_pos, last_pos] = find_number_range(a, 0, n - 1, k);
    cout << first_pos << " " << last_pos << "\n";
  }

  return 0;
}