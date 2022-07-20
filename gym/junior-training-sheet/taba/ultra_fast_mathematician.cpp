#include <iostream>
#include <string>

using namespace std;

int main() {
  string s, t, r = "";

  cin >> s >> t;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] != t[i]) {
      r += '1';
    } else {
      r += '0';
    }
  }

  cout << r << "\n";

  return 0;
}