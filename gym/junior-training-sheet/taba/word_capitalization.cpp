#include <iostream>
#include <string>

using namespace std;

int main() {
  string s;

  cin >> s;
  if (s[0] >= 'a' && s[0] <= 'z') {
    s[0] -= 'a' - 'A';
  }

  cout << s << "\n";

  return 0;
}