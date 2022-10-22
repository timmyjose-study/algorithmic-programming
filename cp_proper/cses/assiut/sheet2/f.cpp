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

  for (int i = 1; i <= 12; i++) {
    cout << n << " * " << i << " = " << (n * i) << "\n";
  }

  return 0;
}