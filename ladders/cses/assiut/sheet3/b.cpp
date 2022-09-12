#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, k;
  cin >> n;

  vector<int> a(n);

  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  cin >> k;

  int pos = -1;
  for (int i = 0; i < n; i++) {
    if (a[i] == k) {
      pos = i;
      break;
    }
  }

  cout << pos << "\n";

  return 0;
}