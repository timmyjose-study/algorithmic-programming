#include <algorithm>
#include <cctype>
#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;

  cin >> s;

  int lc = 0, uc = 0;
  for (char c : s) {
    if (islower(c)) {
      lc++;
    } else {
      uc++;
    }
  }

  if (lc >= uc) {
    transform(s.begin(), s.end(), s.begin(), ::tolower);
  } else {
    transform(s.begin(), s.end(), s.begin(), ::toupper);
  }

  cout << s << "\n";

  return 0;
}