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
    if (a[i] < 0) {
      a[i] = 2;
    } else if (a[i] > 0) {
      a[i] = 1;
    }
  }

  for (int e : a) {
    cout << e << " ";
  }
  cout << "\n";

  return 0;
}