#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  int d1 = n % 10;
  n /= 10;
  int d2 = n % 10;

  cout << (d1 % d2 == 0 || d2 % d1 == 0 ? "YES" : "NO") << "\n";

  return 0;
}