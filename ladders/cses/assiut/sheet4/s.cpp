#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  cin >> s;

  int ls = 0, rs = 0;
  vector<string> a;
  string word = "";

  for (char c : s) {
    if (c == 'L') {
      ls++;
      word += c;
    } else {
      rs++;
      word += c;
    }

    if (ls == rs) {
      a.push_back(word);
      word = "";
    }
  }

  cout << a.size() << "\n";
  for (int i = 0; i < a.size(); i++) {
    cout << a[i];
    cout << "\n";
  }

  return 0;
}