#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m;
  cin >> n >> m;

  vector<int> a(n), b(m);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  for (int j = 0; j < m; j++) {
    cin >> b[j];
  }

  int aidx = 0, bidx = 0;
  while (aidx < n) {
    if (a[aidx] == b[bidx]) {
      bidx++;
    }
    aidx++;
  }

  cout << (bidx == m ? "YES" : "NO") << "\n";

  return 0;
}