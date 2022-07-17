#include <iostream>
#include <string>

using namespace std;

int main() {
  int tt;
  string s;

  auto IsGood = [](const string &s) {
    return s.find("010") != string::npos || s.find("101") != string::npos;
  };

  cin >> tt;
  while (tt--) {
    cin >> s;
    cout << (IsGood(s) ? "Good" : "Bad") << "\n";
  }

  return 0;
}