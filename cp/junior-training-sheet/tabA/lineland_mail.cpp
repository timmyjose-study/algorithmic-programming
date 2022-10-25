#include <algorithm>
#include <iostream>
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

  cout << abs(a[0] - a[1]) << " " << abs(a[0] - a[n - 1]) << "\n";

  for (int i = 1; i < n - 1; i++) {
    int d1 = min(abs(a[i] - a[i - 1]), abs(a[i] - a[i + 1]));
    int d2 = max(abs(a[i] - a[0]), abs(a[i] - a[n - 1]));

    cout << min(d1, d2) << " " << max(d1, d2) << "\n";
  }
  cout << abs(a[n - 1] - a[n - 2]) << " " << abs(a[n - 1] - a[0]) << "\n ";

  return 0;
}