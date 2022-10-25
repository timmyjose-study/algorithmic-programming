#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;

  cin >> s;

  int sol = 0;
  char curr = 'a';

  for (char c : s) {
    sol += min(abs(c - curr), 26 - abs(c - curr));
    curr = c;
  }

  cout << sol << "\n";

  return 0;
}