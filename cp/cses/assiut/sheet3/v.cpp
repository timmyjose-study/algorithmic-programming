#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m, d;
  cin >> n >> m;

  vector<int> b(m);
  for (int i = 0; i < m; i++) {
    b[i] = 0;
  }

  for (int i = 0; i < n; i++) {
    cin >> d;
    b[d - 1]++;
  }

  for (int f : b) {
    cout << f << "\n";
  }

  return 0;
}