#include <algorithm>
#include <iostream>
#include <string>
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

    int max_sum = 0, curr_sum = 0;
    int window_start = 0;

    for (int window_end = 0; window_end < n; window_end++) {
      curr_sum += a[window_end];

      if (window_end >= k - 1) {
        max_sum = max(max_sum, curr_sum);
        curr_sum -= a[window_start];
        window_start++;
      }
    }

    cout << max_sum << "\n";
  }

  return 0;
}