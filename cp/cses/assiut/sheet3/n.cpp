#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int a, b;
  string s;

  cin >> a >> b >> s;
  if (s[a] != '-') {
    cout << "No\n";
    return 0;
  }

  for (int i = 0; i < a + b + 1; i++) {
    if (i == a) {
      continue;
    }
    if (!(s[i] >= '0' && s[i] <= '9')) {
      cout << "No\n";
      return 0;
    }
  }

  cout << "Yes\n";

  return 0;
}