#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s;
  getline(cin, s);

  auto pos = s.find("\\");
  cout << s.substr(0, pos) << "\n";

  return 0;
}