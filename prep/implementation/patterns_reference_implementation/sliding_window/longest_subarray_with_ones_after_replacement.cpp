#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

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

    int max_len = 0, window_start = 0;
    int max_ones_count = 0;

    for (int window_end = 0; window_end < n; window_end++) {
      if (a[window_end] == 1) {
        max_ones_count++;
      }

      if (window_end - window_start + 1 - max_ones_count > k) {
        if (a[window_start] == 1) {
          max_ones_count--;
        }
        window_start++;
      }

      max_len = max(max_len, window_end - window_start + 1);
    }

    cout << max_len << "\n";
  }

  return 0;
}