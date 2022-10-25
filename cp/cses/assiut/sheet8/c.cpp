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

  vector<int> a(n);
  long long as = 0LL;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    as += (long long)a[i];
  }

  vector<int> b(m);
  long long bs = 0LL;
  for (int j = 0; j < m; j++) {
    cin >> b[j];
    bs += (long long)b[j];
  }

  cout << (as == bs ? "Yes" : "No") << "\n";

  return 0;
}