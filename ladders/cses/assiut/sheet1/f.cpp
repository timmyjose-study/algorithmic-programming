#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n, m;

  cin >> n >> m;
  cout << (n % 10 + m % 10) << "\n";

  return 0;
}