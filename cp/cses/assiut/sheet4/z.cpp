#include <cctype>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  bool blk = false;
  int proc_cnt = 0;

  while (getline(cin, s)) {
    if (s.empty()) {
      continue;
    }

    int i = 0;
    while (i < s.size()) {
      if (!blk && s[i] == '/' && s[i + 1] == '/') {
        break;
      }

      if (!blk && i < s.size() - 1 && s[i] == '/' && s[i + 1] == '*') {
        blk = true;
        i += 2;
      }

      if (blk && i < s.size() - 1 && s[i] == '*' && s[i + 1] == '/') {
        blk = false;
        i += 2;
      }

      if (i >= s.size()) {
        break;
      }

      if (blk) {
        i++;
      } else {
        cout << s[i];
        if (!isspace(s[i])) {
          proc_cnt++;
        }
        i++;
      }
    }

    if (proc_cnt) {
      cout << "\n";
    }
    proc_cnt = 0;
  }

  return 0;
}