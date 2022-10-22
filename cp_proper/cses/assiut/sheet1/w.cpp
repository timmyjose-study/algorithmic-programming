#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  long long l, r, res;
  char op, tmp;

  cin >> l >> op >> r >> tmp >> res;

  switch (op) {
  case '+':
    if (l + r == res) {
      cout << "Yes\n";
    } else {
      cout << (l + r) << "\n";
    }
    break;

  case '-':
    if (l - r == res) {
      cout << "Yes\n";
    } else {
      cout << (l - r) << "\n";
    }
    break;

  default:
    if (l * r == res) {
      cout << "Yes\n";
    } else {
      cout << (l * r) << "\n";
    }
  }

  return 0;
}