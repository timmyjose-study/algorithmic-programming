#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  cin >> tt;

  while (tt--) {
    string s, t;
    cin >> s >> t;

    int slen = s.size(), tlen = t.size();
    int spos = 0, tpos = 0;

    while (spos < slen || tpos < tlen) {
      if (spos < slen) {
        cout << s[spos++];
      }

      if (tpos < tlen) {
        cout << t[tpos++];
      }
    }
    cout << "\n";
  }

  return 0;
}