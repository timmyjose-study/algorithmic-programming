#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, m;

  cin >> n >> m;
  cout << ((n % m == 0) || (m % n == 0) ? "Multiples" : "No Multiples") << "\n";

  return 0;
}