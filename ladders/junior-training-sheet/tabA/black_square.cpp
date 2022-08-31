#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int a1, a2, a3, a4;
  cin >> a1 >> a2 >> a3 >> a4;

  string s;
  cin >> s;

  int sol = 0;
  for (char c : s) {
    switch (c) {
    case '1':
      sol += a1;
      break;

    case '2':
      sol += a2;
      break;

    case '3':
      sol += a3;
      break;

    case '4':
      sol += a4;
      break;
    }
  }

  cout << sol << "\n";

  return 0;
}