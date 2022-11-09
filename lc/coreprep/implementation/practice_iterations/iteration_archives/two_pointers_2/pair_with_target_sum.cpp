#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n) / o(1)
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

    int left = 0, right = n - 1;
    int lpos = -1, rpos = -1;

    while (left < right) {
      int sum = a[left] + a[right];

      if (sum == s) {
        lpos = left;
        rpos = right;
        break;
      } else if (sum < s) {
        left++;
      } else {
        right--;
      }
    }

    cout << lpos << " " << rpos << "\n";
  }

  return 0;
}