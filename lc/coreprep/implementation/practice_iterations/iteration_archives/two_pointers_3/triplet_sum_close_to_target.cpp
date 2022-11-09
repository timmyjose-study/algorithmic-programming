#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

// O(n2) / O(n)
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

    sort(a.begin(), a.end());

    int min_diff = numeric_limits<int>::max();
    for (int i = 0; i < n - 2; i++) {
      int left = i + 1, right = n - 1;

      while (left < right) {
        int diff = s - a[i] - a[left] - a[right];

        if (abs(diff) < abs(min_diff) ||
            (abs(diff) == abs(min_diff) && diff > min_diff)) {
          min_diff = diff;
        }

        if (diff > 0) {
          left++;
        } else {
          right--;
        }
      }
    }

    cout << (s - min_diff) << "\n";
  }

  return 0;
}