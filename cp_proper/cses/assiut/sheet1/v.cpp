#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int l, r;
  char op;

  cin >> l >> op >> r;

  switch (op) {
  case '<':
    cout << (l < r ? "Right" : "Wrong") << "\n";
    break;

  case '>':
    cout << (l > r ? "Right" : "Wrong") << "\n";
    break;

  default:
    cout << (l == r ? "Right" : "Wrong") << "\n";
  }

  return 0;
}