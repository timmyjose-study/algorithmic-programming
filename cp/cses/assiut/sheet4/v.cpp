#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  cin >> s;

  int pos;
  while ((pos = s.find("EGYPT")) != string::npos) {
    s.replace(pos, 5, " ");
  }

  cout << s << "\n";

  return 0;
}