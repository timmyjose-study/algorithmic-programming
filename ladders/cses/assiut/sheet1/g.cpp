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

  unsigned long long s = (unsigned long long)n * (n + 1) / 2;
  cout << s << "\n";

  return 0;
}