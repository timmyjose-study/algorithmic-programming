#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int p;

  while (cin >> p) {
    if (p == 1999) {
      cout << "Correct\n";
      break;
    } else {
      cout << "Wrong\n";
    }
  }

  return 0;
}