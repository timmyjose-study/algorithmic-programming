#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

// O(n) / O(1)
int smallest_subarray(const vector<int> &a, int s) {
  int min_len = numeric_limits<int>::max();
  int sum = 0, window_start = 0;

  for (int window_end = 0; window_end < a.size(); window_end++) {
    sum += a[window_end];

    while (sum >= s) {
      min_len = min(min_len, window_end - window_start + 1);
      sum -= a[window_start];
      window_start++;
    }
  }

  return min_len == numeric_limits<int>::max() ? 0 : min_len;
}

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

    cout << smallest_subarray(a, s) << "\n";
  }

  return 0;
}