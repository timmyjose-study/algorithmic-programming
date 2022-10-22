#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s, t;

  cin >> s >> t;

  if (s != t) {
    cout << max(s.size(), t.size()) << "\n";
  } else {
    cout << -1 << "\n";
  }

  return 0;
}