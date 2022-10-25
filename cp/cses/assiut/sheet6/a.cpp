#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n;
  cin >> n;

  cout << (n & (n - 1) ? "NO" : "YES") << "\n";

  return 0;
}