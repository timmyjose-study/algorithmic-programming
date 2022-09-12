#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool is_palindrom(int n) {
  string s = "";
  while (n) {
    s += n % 2;
    n >>= 1;
  }

  for (int i = 0, j = s.size() - 1; i < j; i++, j--) {
    if (s[i] != s[j]) {
      return false;
    }
  }
  return true;
}

bool is_odd(int n) { return n % 2 == 1; }

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  cout << (is_odd(n) && is_palindrom(n) ? "YES" : "NO") << "\n";

  return 0;
}