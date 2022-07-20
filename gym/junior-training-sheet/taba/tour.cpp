#include <iostream>
#include <string>

using namespace std;

int main() {
  string s, t = "";

  auto IsVowel = [](char c) {
    switch (c) {
    case 'a':
    case 'A':
    case 'e':
    case 'E':
    case 'i':
    case 'I':
    case 'o':
    case 'O':
    case 'y':
    case 'Y':
    case 'u':
    case 'U':
      return true;
    default:
      return false;
    }
  };

  cin >> s;
  for (auto &c : s) {
    if (IsVowel(c)) {
      continue;
    } else if (c >= 'A' && c <= 'Z') {
      t += '.';
      t += c + 32;
    } else {
      t += '.';
      t += c;
    }
  }

  cout << t << "\n";

  return 0;
}