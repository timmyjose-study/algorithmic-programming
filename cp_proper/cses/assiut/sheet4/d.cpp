#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s, t;
  cin >> s >> t;

  cout << s.size() << " " << t.size() << "\n";
  cout << s << t << "\n";

  char c = s[0];
  s[0] = t[0];
  t[0] = c;
  cout << s << " " << t << "\n";

  return 0;
}