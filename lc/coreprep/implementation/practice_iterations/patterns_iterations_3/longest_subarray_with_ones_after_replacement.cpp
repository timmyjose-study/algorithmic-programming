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

// O(n) / O(1)
int longest_subarray_with_max_ones_after_replacement(const vector<int> &a,
                                                     int k) {
  int max_ones = 0, window_start = 0, max_len = 0;
  for (int window_end = 0; window_end < a.size(); window_end++) {
    if (a[window_end] == 1) {
      max_ones++;
    }

    while (window_end - window_start + 1 - max_ones > k) {
      if (a[window_start] == 1) {
        max_ones--;
      }
      window_start++;
    }

    max_len = max(max_len, window_end - window_start + 1);
  }

  return max_len;
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

    cout << longest_subarray_with_max_ones_after_replacement(a, k) << "\n";
  }

  return 0;
}