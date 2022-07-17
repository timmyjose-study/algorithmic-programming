#include <algorithm>
#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
  int tt, n, m, d;
  unordered_set<int> s;

  cin >> tt;
  while (tt--) {
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
      cin >> d;
      s.insert(d);
    }

    cout << (s.size() < m ? "Yes" : "No") << "\n";
    s.clear();
  }

  return 0;
}