#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main() {
  int n;
  string s;
  int zc = 0, oc = 0;

  cin >> n >> s;
  for (auto &c : s) {
    c == '0' ? zc++ : oc++;
  }

  cout << abs(zc - oc) << "\n";
  return 0;
}