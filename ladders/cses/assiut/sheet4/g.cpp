#include <cctype>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  cin >> s;

  for (int i = 0; i < s.size(); i++) {
    if (islower(s[i])) {
      s[i] = toupper(s[i]);
    } else if (isupper(s[i])) {
      s[i] = tolower(s[i]);
    } else if (s[i] == ',') {
      s[i] = ' ';
    }
  }
  cout << s << "\n";

  return 0;
}