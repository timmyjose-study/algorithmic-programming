#include <iostream>
#include <set>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  set<char> t;

  getline(cin, s);
  for (int i = 1; i < s.size() - 1; i += 3) {
    t.insert((s[i]));
  }

  cout << t.size() << "\n";

  return 0;
}