#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned int a, b;
  cin >> a >> b;
  cout << (a ^ b) << "\n";

  return 0;
}