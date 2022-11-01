#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

// O(n) / O(1)
int max_sum(const vector<int> &a, int k) {
  int n = a.size();
  int max_sum = numeric_limits<int>::min();
  int curr_sum = 0, window_start = 0;

  for (int window_end = 0; window_end < n; window_end++) {
    curr_sum += a[window_end];

    if (window_end >= k - 1) {
      max_sum = max(max_sum, curr_sum);
      curr_sum -= a[window_start];
      window_start++;
    }
  }

  return max_sum;
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

    cout << max_sum(a, k) << "\n";
  }

  return 0;
}