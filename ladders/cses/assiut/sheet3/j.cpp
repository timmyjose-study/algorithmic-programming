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

  int min_val = a[0], f = 0;
  for (int i = 1; i < n; i++) {
    min_val = min(min_val, a[i]);
  }

  for (int e : a) {
    if (e == min_val) {
      f++;
    }
  }

  cout << (f % 2 == 1 ? "Lucky" : "Unlucky") << "\n";

  return 0;
}