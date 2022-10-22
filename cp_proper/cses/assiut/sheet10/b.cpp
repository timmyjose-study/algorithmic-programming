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

  int slen = s.size(), tlen = t.size();

  int cnt = 0;
  for (int i = slen - 1, j = tlen - 1; i >= 0 && j >= 0; i--, j--) {
    if (s[i] != t[j]) {
      break;
    }
    cnt++;
  }

  cout << (slen + tlen - 2 * cnt) << "\n";

  return 0;
}