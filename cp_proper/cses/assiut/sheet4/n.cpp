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

  int cnt = 1;
  char curr = s[0];

  for (int i = 1; i < s.size(); i++) {
    if (curr != s[i]) {
      curr = s[i];
      cnt++;
    }
  }

  cout << cnt << "\n";

  return 0;
}