#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  cin >> s;

  int ec = 0, gc = 0, yc = 0, pc = 0, tc = 0;
  for (char c : s) {
    if (c == 'E' || c == 'e') {
      ec++;
    } else if (c == 'G' || c == 'g') {
      gc++;
    } else if (c == 'Y' || c == 'y') {
      yc++;
    } else if (c == 'P' || c == 'p') {
      pc++;
    } else if (c == 'T' || c == 't') {
      tc++;
    }
  }

  cout << min(min(ec, gc), min(min(yc, pc), tc)) << "\n";

  return 0;
}