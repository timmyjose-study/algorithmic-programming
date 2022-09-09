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

  auto p = string::npos;
  char op;

  auto pos = [&]() {
    p = s.find("+");
    op = '+';

    if (p == string::npos) {
      p = s.find("-");
      op = '-';

      if (p == string::npos) {
        p = s.find("*");
        op = '*';

        if (p == string::npos) {
          p = s.find("/");
          op = '/';
        }
      }
    }
  };

  pos();

  int l = stoi(s.substr(0, p));
  int r = stoi(string(s.substr(p + 1, s.size() - p)));

  switch (op) {
  case '+':
    cout << l + r << "\n ";
    break;

  case '-':
    cout << (l - r) << "\n";
    break;

  case '*':
    cout << (l * r) << "\n";
    break;

  default:
    cout << (l / r) << "\n";
    break;
  }

  return 0;
}