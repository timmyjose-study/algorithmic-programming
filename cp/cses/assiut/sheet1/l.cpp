#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string s, t;

  getline(cin, s);
  getline(cin, t);

  auto lname = [](string u) {
    auto pos = u.find(" ");
    return u.substr(pos + 1, u.length() - pos);
  };

  cout << (lname(s) == lname(t) ? "ARE Brothers" : "NOT") << "\n";

  return 0;
}