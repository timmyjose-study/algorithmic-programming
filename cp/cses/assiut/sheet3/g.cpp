#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  for (int i = 0, j = n - 1; i < j; i++, j--) {
    if (a[i] != a[j]) {
      cout << "NO\n";
      return 0;
    }
  }

  cout << "YES\n";

  return 0;
}