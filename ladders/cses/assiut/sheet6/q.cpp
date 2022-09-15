#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int l, r, m;
  cin >> l >> r >> m;

  long long p = 1LL;
  for (int i = l; i <= r; i++) {
    p = (p % m) * ((long long)i % m) % m;
  }

  cout << p << "\n";

  return 0;
}