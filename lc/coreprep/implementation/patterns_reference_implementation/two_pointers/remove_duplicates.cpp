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

    int next_elem = 1;
    for (int i = 1; i < a.size(); i++) {
      if (a[next_elem - 1] != a[i]) {
        a[next_elem++] = a[i];
      }
    }

    cout << next_elem << "\n";
  }

  return 0;
}