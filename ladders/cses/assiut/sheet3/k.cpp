#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  string s;

  cin >> n >> s;

  int sol = 0;
  for (int i = 0; i < n; i++) {
    sol += s[i] - '0';
  }

  cout << sol << "\n";

  return 0;
}