#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n, x, d = 0;
  string s;

  cin >> n >> x;
  cin.ignore(1, '\n');

  for (int i = 0; i < n; i++) {
    getline(cin, s);
    if (s[0] == '+') {
      x += stoi(s.substr(2));
    } else {
      int neg = stoi(s.substr(2));
      if (x >= neg) {
        x -= neg;
      } else {
        d++;
      }
    }
  }

  cout << x << " " << d << "\n";

  return 0;
}