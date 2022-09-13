#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto is_palindrome = [](const string &s) {
    for (int i = 0, j = s.size() - 1; i < j; i++, j--) {
      if (s[i] != s[j]) {
        return false;
      }
    }
    return true;
  };

  string s;
  cin >> s;

  for (int i = 0, j = s.size() - 1; i <= j; i++, j--) {
    if (s[i] != '?' && s[j] == '?') {
      s[j] = s[i];
    } else if (s[i] == '?' && s[j] != '?') {
      s[i] = s[j];
    } else if (s[i] == '?' && s[j] == '?') {
      s[i] = s[j] = 'a';
    }
  }

  cout << (is_palindrome(s) ? s : "-1") << "\n";

  return 0;
}