#include <algorithm>
#include <iomanip>
#include <iostream>
#include <vector>

using namespace std;

// O(n) / O(1)
vector<double> averages(const vector<int> &a, int k) {
  int n = a.size();
  vector<double> res(n - k + 1);
  int window_start = 0, sum = 0;

  for (int window_end = 0; window_end < n; window_end++) {
    sum += a[window_end];

    if (window_end >= k - 1) {
      res[window_start] = (double)sum / (double)k;
      sum -= a[window_start];
      window_start++;
    }
  }

  return res;
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

    auto res = averages(a, k);
    for (double r : res) {
      cout << fixed << setprecision(1) << r << " ";
    }
    cout << "\n";
  }

  return 0;
}