#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto is_valid = [](const vector<int> &a, int n) {
    for (int i = 0; i < n; i++) {
      if (a[i] % 2 == 1) {
        return false;
      }
    }
    return true;
  };

  int n;
  cin >> n;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  int cnt = 0;
  while (is_valid(a, n)) {
    for (int i = 0; i < n; i++) {
      a[i] /= 2;
    }
    cnt++;
  }

  cout << cnt << "\n";

  return 0;
}