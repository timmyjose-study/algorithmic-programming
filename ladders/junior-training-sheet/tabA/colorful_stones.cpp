#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s, t;
  int pos = 0;

  cin >> s >> t;

  for (char c : t) {
    if (c == s[pos]) {
      pos++;
    }
  }

  cout << (pos + 1) << "\n";

  return 0;
}