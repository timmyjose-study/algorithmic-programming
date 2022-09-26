#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

int kadane(const vector<int> &a) {
  int max_so_far = numeric_limits<int>::min();
  int max_ending_here = 0;

  for (int e : a) {
    max_ending_here += e;
    max_so_far = max(max_so_far, max_ending_here);

    if (max_ending_here < 0) {
      max_ending_here = 0;
    }
  }

  return max_so_far;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << kadane(a) << "\n";
  }

  return 0;
}