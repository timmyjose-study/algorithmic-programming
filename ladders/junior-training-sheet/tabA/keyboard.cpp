#include <iostream>
#include <map>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  const string kb[] = {"qwertyuiop ", "asdfghjkl;", "zxcvbnm,./"};

  map<char, pair<int, int>> c2p;
  map<pair<int, int>, char> p2c;

  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < kb[i].size(); j++) {
      c2p[kb[i][j]] = make_pair(i, j);
      p2c[make_pair(i, j)] = kb[i][j];
    }
  }

  char dir;
  string s;

  cin >> dir >> s;
  int offset = dir == 'L' ? 1 : -1;

  string sol = "";
  for (char c : s) {
    pair<int, int> p = c2p[c];
    sol += p2c[make_pair(p.first, p.second + offset)];
  }

  cout << sol << "\n";

  return 0;
}