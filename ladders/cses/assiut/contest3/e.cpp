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

  int cnt = 0;
  bool plus = a[0] >= 0 ? true : false;
  for (int i = 1; i < n; i++) {
    if (plus && a[i] >= 0) {
      cnt++;
    } else if (!plus && a[i] < 0) {
      cnt++;
    }

    if (plus) {
      plus = false;
    } else {
      plus = true;
    }
  }

  cout << cnt << "\n";

  return 0;
}