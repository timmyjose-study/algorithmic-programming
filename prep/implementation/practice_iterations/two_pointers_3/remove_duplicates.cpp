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

    int next_pos = 1;
    for (int i = 1; i < n; i++) {
      if (a[next_pos - 1] != a[i]) {
        a[next_pos++] = a[i];
      }
    }

    int len = next_pos;
    cout << len << "\n";
    for (int i = 0; i < len; i++) {
      cout << a[i] << " ";
    }
    cout << "\n";
  }

  return 0;
}