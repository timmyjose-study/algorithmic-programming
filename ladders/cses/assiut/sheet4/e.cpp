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

  int sum = 0;
  for (char c : s) {
    sum += c - '0';
  }
  cout << sum << "\n";

  return 0;
}