#include <algorithm>
#include <iostream>
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

    int left = 0, right = n - 1;
    int next_pos = n - 1;
    vector<int> res(n);

    while (left < right) {
      if (abs(a[left]) >= abs(a[right])) {
        res[next_pos--] = a[left] * a[left];
        left++;
      } else {
        res[next_pos--] = a[right] * a[right];
        right--;
      }
    }

    for (int e : res) {
      cout << e << " ";
    }
    cout << "\n";
  }

  return 0;
}