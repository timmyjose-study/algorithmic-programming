#include <algorithm>
#include <iostream>
#include <set>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m, d;
  set<int> s;

  cin >> n;
  for (int i = 0; i < 2; i++) {
    cin >> m;
    for (int j = 0; j < m; j++) {
      cin >> d;
      s.insert(d);
    }
  }

  cout << (s.size() == n ? "I become the guy." : "Oh, my keyboard!") << "\n";

  return 0;
}