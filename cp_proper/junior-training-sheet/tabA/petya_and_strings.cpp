#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s, t;

  cin >> s >> t;

  transform(s.begin(), s.end(), s.begin(), ::tolower);
  transform(t.begin(), t.end(), t.begin(), ::tolower);

  int slen = s.size(), tlen = t.size();

  for (int i = 0; i < min(slen, tlen); i++) {
    if (s[i] > t[i]) {
      cout << 1 << "\n";
      return 0;
    } else if (s[i] < t[i]) {
      cout << -1 << "\n";
      return 0;
    }
  }

  if (slen == tlen) {
    cout << 0 << "\n";
  } else if (slen < tlen) {
    cout << -1 << "\n";
  } else {
    cout << 1 << "\n";
  }

  return 0;
}