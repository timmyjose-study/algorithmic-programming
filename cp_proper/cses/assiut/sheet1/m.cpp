#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  char c;

  cin >> c;

  if (c >= '0' && c <= '9') {
    cout << "IS DIGIT"
         << "\n";
  } else if (c >= 'a' && c <= 'z') {
    cout << "ALPHA\nIS SMALL"
         << "\n";
  } else {
    cout << "ALPHA\nIS CAPITAL"
         << "\n";
  }

  return 0;
}