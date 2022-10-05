#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n) / O(1)
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

    int max_ones = 0, window_start = 0, max_len = 0;

    for (int window_end = 0; window_end < n; window_end++) {
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

    cout << max_len << "\n";
  }

  return 0;
}