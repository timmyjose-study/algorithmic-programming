#include <algorithm>
#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, d, mx = -1;
  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> d;
    mx = max(mx, d);
  }

  cout << mx << "\n";

  return 0;
}