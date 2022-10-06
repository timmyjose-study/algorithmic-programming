#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

// O(n) / O(n)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, s;
  cin >> tt;

  while (tt--) {
    cin >> n >> s;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    unordered_map<int, int> m;
    int lpos = -1, rpos = -1;
    for (int i = 0; i < n; i++) {
      if (m.find(s - a[i]) != m.end()) {
        lpos = i;
        rpos = m[s - a[i]];
        break;
      }
      m[a[i]] = i;
    }

    cout << lpos << " " << rpos << "\n";
  }

  return 0;
}