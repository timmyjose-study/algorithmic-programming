#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

// O(n) / O(1)
int longest_subarray(const vector<int> &a, int k) {
  int max_ones = 0, window_start = 0;
  int max_len = numeric_limits<int>::min();

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

    cout << longest_subarray(a, k) << "\n";
  }

  return 0;
}