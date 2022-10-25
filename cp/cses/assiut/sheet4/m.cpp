#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  const string hello = "hello";
  int hidx = 0;

  string s;
  cin >> s;

  for (char c : s) {
    if (c == hello[hidx]) {
      hidx++;
    }
  }

  cout << (hidx == 5 ? "YES" : "NO") << "\n";

  return 0;
}