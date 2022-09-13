#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  string s;
  cin >> s;

  if (s.size() < 3) {
    cout << s << "\n";
  } else {
    int idx = s.size() - 2;
    string sol = "";
    int lim = s.size() % 2 == 0 ? 0 : 1;
    int diff = s.size() % 2 == 0 ? 3 : 1;

    while (idx >= lim) {
      sol += s[idx];
      idx -= 2;
    }

    idx += diff;

    while (idx < s.size()) {
      sol += s[idx];
      idx += 2;
    }

    cout << sol << "\n";
  }

  return 0;
}