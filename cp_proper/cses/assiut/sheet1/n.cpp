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

  if (c >= 'a' && c <= 'z') {
    cout << (char)(c - 32) << "\n";
  } else {
    cout << (char)(c + 32) << "\n";
  }

  return 0;
}