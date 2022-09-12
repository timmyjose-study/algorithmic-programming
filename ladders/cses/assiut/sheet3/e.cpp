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

  int min = a[0], min_pos = 0;
  for (int i = 1; i < n; i++) {
    if (a[i] < min) {
      min = a[i];
      min_pos = i;
    }
  }

  cout << min << " " << (min_pos + 1) << "\n";

  return 0;
}