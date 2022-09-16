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

  int fidx = 0, ridx = n - 1;
  while (true) {
    cout << a[fidx++] << " ";

    if (n % 2 == 0 && fidx == ridx) {
      cout << a[ridx] << " ";
      break;
    } else if (n % 2 == 1 && fidx > ridx) {
      break;
    }
    cout << a[ridx--] << " ";
  }
  cout << "\n";

  return 0;
}