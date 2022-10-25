#include <cctype>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool is_vowel(char c) {
  switch (tolower(c)) {
  case 'a':
  case 'e':
  case 'i':
  case 'o':
  case 'u':
    return true;
  default:
    return false;
  }
}

int vowel_count(const string &s) {
  if (s == "") {
    return 0;
  }

  return is_vowel(s[0]) ? 1 + vowel_count(s.substr(1, s.size() - 1))
                        : vowel_count(s.substr(1, s.size() - 1));
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  getline(cin, s);

  cout << vowel_count(s) << "\n";

  return 0;
}