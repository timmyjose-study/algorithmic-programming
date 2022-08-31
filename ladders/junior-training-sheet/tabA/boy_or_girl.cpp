#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_set>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;

  cin >> s;

  unordered_set<char> t;

  for (char c : s) {
    t.insert(c);
  }

  cout << (t.size() % 2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!") << "\n";

  return 0;
}