#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> s;

    if (s.size() > 10) {
      cout << s[0] << s.size() - 2 << s[s.size() - 1] << "\n";
    } else {
      cout << s << "\n";
    }
  }

  return 0;
}