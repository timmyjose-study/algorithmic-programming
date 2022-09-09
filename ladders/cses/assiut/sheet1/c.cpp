#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  long long n, m;

  cin >> n >> m;
  cout << n << " + " << m << " = " << (n + m) << "\n";
  cout << n << " * " << m << " = " << (n * m) << "\n";
  cout << n << " - " << m << " = " << (n - m) << "\n";

  return 0;
}