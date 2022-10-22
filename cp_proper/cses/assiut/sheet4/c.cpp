#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto is_smaller = [](const string &s, const string &t) {
    int slen = s.size(), tlen = t.size();

    for (int i = 0; i < min(slen, tlen); i++) {
      if (s[i] < t[i]) {
        return true;
      } else if (s[i] > t[i]) {
        return false;
      }
    }

    if (slen < tlen) {
      return true;
    } else if (slen > tlen) {
      return false;
    }
    return true;
  };

  string s, t;
  cin >> s >> t;

  cout << (is_smaller(s, t) ? s : t) << "\n";

  return 0;
}