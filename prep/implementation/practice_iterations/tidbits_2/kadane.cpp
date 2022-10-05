#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

// O(n) / O(1)
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

    int max_so_far = numeric_limits<int>::min();
    int max_ending_here = 0;
    int start = 0, end = 0, s = 0;

    for (int i = 0; i < n; i++) {
      max_ending_here += a[i];

      if (max_so_far < max_ending_here) {
        max_so_far = max_ending_here;
        start = s;
        end = i;
      }

      if (max_ending_here < 0) {
        max_ending_here = 0;
        s = i + 1;
      }
    }

    cout << max_so_far << "\n";
    for (int i = start; i <= end; i++) {
      cout << a[i] << " ";
    }
    cout << "\n";
  }

  return 0;
}