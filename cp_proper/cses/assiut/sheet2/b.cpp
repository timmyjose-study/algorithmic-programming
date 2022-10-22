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

  int ne = 0;
  for (int i = 1; i <= n; i++) {
    if (i % 2 == 0) {
      ne++;
      cout << i << "\n";
    }
  }

  if (!ne) {
    cout << -1 << "\n";
  }

  return 0;
}