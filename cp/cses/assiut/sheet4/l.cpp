#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, nq, lpos, rpos;
  cin >> n >> nq;

  string s, cmd;
  cin >> s;

  while (nq--) {
    cin >> cmd;

    if (cmd == "substr") {
      cin >> lpos >> rpos;
      lpos--;
      cout << s.substr(lpos, rpos) << "\n";
    } else if (cmd == "pop_back") {
      s = s.substr(0, s.size() - 1);
    } else if (cmd == "front") {
      cout << s[0] << "\n";
    } else if (cmd == "back") {
      cout << s[s.size() - 1] << "\n";
    } else if (cmd == "sort") {
      cin >> lpos >> rpos;
      lpos--;
      sort(s.begin() + lpos, s.begin() + rpos);
    } else if (cmd == "reverse") {
      cin >> lpos >> rpos;
      lpos--;
      rpos--;
      for (int i = lpos, j = rpos; i < j; i++, j--) {
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
      }
    } else if (cmd == "print") {
      cin >> lpos;
      lpos--;
      cout << s[lpos] << "\n";
    } else if (cmd == "substr") {
      cin >> lpos >> rpos;
      lpos--;
      cout << cmd.substr(lpos, rpos) << "\n";
    } else if (cmd == "push_back") {
      char c;
      cin >> c;
      s += c;
    }
  }

  return 0;
}