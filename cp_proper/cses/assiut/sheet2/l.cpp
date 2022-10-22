#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto gcd = [](int a, int b) {
    int t;
    while (b) {
      t = b;
      b = a % b;
      a = t;
    }
    return a;
  };

  int n, m;
  cin >> n >> m;

  cout << gcd(n, m) << "\n";

  return 0;
}