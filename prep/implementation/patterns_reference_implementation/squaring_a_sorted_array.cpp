#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

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

    vector<int> res(n);
    int left = 0, right = n - 1, next_pos = n - 1;

    while (left <= right) {
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