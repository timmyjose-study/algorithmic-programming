#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

enum Find { FindMin, FindMax };

int binary_search(const vector<int> &a, int low, int high, int k, Find find) {
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

pair<int, int> calculate_number_range(const vector<int> &a, int low, int high,
                                      int k) {
  int pos1 = binary_search(a, low, high, k, FindMin);
  int pos2 = binary_search(a, low, high, k, FindMax);

  return make_pair<>(pos1, pos2);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto [pos1, pos2] = calculate_number_range(a, 0, n - 1, k);
    cout << pos1 << " " << pos2 << "\n";
  }

  return 0;
}