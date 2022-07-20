#include <iostream>
#include <string>

using namespace std;

int main() {
  string s, t;

  cin >> s >> t;
  if (s.size() != t.size()) {
    cout << "NO\n";
  } else {
    bool valid = true;
    for (int i = 0, j = s.size() - 1; i < s.size(); i++, j--) {
      if (s[i] != t[j]) {
        valid = false;
        break;
      }
    }

    cout << (valid ? "YES\n" : "NO\n");
  }

  return 0;
}