#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

// O(n) / O(1)
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

    int min_len = numeric_limits<int>::max();
    int window_start = 0, curr_sum = 0;

    for (int window_end = 0; window_end < n; window_end++) {
      curr_sum += a[window_end];

      while (curr_sum >= s) {
        min_len = min(min_len, window_end - window_start + 1);
        curr_sum -= a[window_start];
        window_start++;
      }
    }

    cout << (min_len == numeric_limits<int>::max() ? 0 : min_len) << "\n";
  }

  return 0;
}