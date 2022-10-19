#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

// O(nk) / O(1)
int kth_smallest_number(const vector<int> &a, int n, int k) {
  int prev_smallest = numeric_limits<int>::min();
  int prev_smallest_idx = -1;
  int curr_smallest = numeric_limits<int>::max();
  int curr_smallest_idx = -1;

  for (int i = 0; i < k; i++) {
    for (int j = 0; j < n; j++) {
      if ((a[j] > prev_smallest && a[j] < curr_smallest) ||
          (a[j] == prev_smallest && j > prev_smallest_idx)) {
        curr_smallest = a[j];
        curr_smallest_idx = j;
      }
    }

    prev_smallest = curr_smallest;
    prev_smallest_idx = curr_smallest_idx;
    curr_smallest = numeric_limits<int>::max();
  }

  return prev_smallest;
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

    cout << kth_smallest_number(a, n, k) << "\n";
  }

  return 0;
}