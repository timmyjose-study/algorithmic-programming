#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool check_n(unsigned long long curr, unsigned long long n) {
  if (curr == n) {
    return true;
  }

  if (curr > n) {
    return false;
  }

  return check_n(curr * 10, n) || check_n(curr * 20, n);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  unsigned long long n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << (check_n(1, n) ? "YES" : "NO") << "\n";
  }

  return 0;
}