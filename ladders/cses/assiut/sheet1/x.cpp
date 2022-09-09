#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int l1, r1, l2, r2;

  cin >> l1 >> r1 >> l2 >> r2;

  if (l1 > r2 || l2 > r1) {
    cout << -1 << "\n";
  } else {
    if (l1 <= l2) {
      cout << min(l2, r1) << " " << min(r1, r2) << "\n";
    } else {
      cout << min(l1, r1) << " " << min(r2, r1) << "\n";
    }
  }

  return 0;
}