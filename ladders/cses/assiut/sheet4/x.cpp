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

    if (slen <= tlen) {
      return true;
    } else {
      return false;
    }
  };

  string s;
  cin >> s;

  int len = s.size();
  string sol = s;
  for (int i = 0; i < len - 1; i++) {
    string l = s.substr(0, i + 1);
    sort(l.begin(), l.end());

    string r = s.substr(i + 1, len - i);
    sort(r.begin(), r.end());

    if (is_smaller(l + r, sol)) {
      sol = l + r;
    }
  }

  cout << sol << "\n";

  return 0;
}