#include <iostream>
#include <string>

using namespace std;

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  string s;
  int a = 0, b = 0;

  cin >> s;
  for (int i = 1; i < s.size(); i += 2) {
    if (s[i - 1] == 'A') {
      a += s[i] - '0';
    } else {
      b += s[i] - '0';
    }
  }

  if (a == 11 || (a - b) >= 2) {
    cout << "A\n";
  } else {
    cout << "B\n";
  }

  return 0;
}