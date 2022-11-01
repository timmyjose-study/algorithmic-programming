#include <algorithm>
#include <iostream>
#include <limits>
#include <vector>

using namespace std;

// O(n2) / O(1)
int find_closest_sum(vector<int> &a, int s) {
  sort(a.begin(), a.end());

  int n = a.size();
  int min_diff = numeric_limits<int>::max();
  for (int i = 0; i < n - 2; i++) {
    int left = i + 1, right = n - 1;

    while (left < right) {
      int diff = s - a[i] - a[left] - a[right];

      if (abs(diff) < min_diff || (abs(diff) == min_diff && diff > min_diff)) {
        min_diff = diff;
      } else if (diff > 0) {
        left++;
      } else {
        right--;
      }
    }
  }

  return s - min_diff;
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

    cout << find_closest_sum(a, s) << "\n";
  }

  return 0;
}