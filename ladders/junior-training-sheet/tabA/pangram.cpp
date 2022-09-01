#include <cctype>
#include <iostream>
#include <map>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  string s;
  map<int, int> m;
  for (int i = 0; i < 26; i++) {
    m[i] = 0;
  }

  cin >> n >> s;
  for (char c : s) {
    if (isupper(c)) {
      m[c + 32 - 'a']++;
    } else {
      m[c - 'a']++;
    }
  }

  for (int i = 0; i < 26; i++) {
    if (!m[i]) {
      cout << "NO\n";
      return 0;
    }
  }

  cout << "YES\n";

  return 0;
}