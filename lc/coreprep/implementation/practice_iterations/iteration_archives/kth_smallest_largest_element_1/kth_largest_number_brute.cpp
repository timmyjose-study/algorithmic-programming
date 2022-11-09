#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

int kth_largest_number(const vector<int> &a, int n, int k) {
  int prev_largest = numeric_limits<int>::max();
  int prev_largest_idx = -1;
  int curr_largest = numeric_limits<int>::min();
  int curr_largest_idx = -1;

  for (int i = 0; i < k; i++) {
    for (int j = 0; j < n; j++) {
      if ((a[j] < prev_largest && a[j] > curr_largest) ||
          (a[j] == prev_largest && j > prev_largest_idx)) {
        curr_largest = a[j];
        curr_largest_idx = j;
      }
    }

    prev_largest = curr_largest;
    prev_largest_idx = curr_largest_idx;
    curr_largest = numeric_limits<int>::min();
  }

  return prev_largest;
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

    cout << kth_largest_number(a, n, k) << "\n";
  }

  return 0;
}