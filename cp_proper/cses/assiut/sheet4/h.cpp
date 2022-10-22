#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  cin >> tt;

  while (tt--) {
    string s;
    cin >> s;

    if (s.find("010") != string::npos || s.find("101") != string::npos) {
      cout << "Good\n";
    } else {
      cout << "Bad\n";
    }
  }

  return 0;
}