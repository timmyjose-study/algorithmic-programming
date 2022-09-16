#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  string n;
  cin >> n;

  int x;
  cin >> x;

  long long tot = 0LL;
  for (char c : n) {
    tot = 10 * tot + (c - '0');
    tot %= x;
  }

  cout << (tot == 0 ? "YES" : "NO") << "\n";

  return 0;
}