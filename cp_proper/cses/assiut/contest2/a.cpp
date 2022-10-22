#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int a, b;
  cin >> a >> b;

  if ((a - b) >= 0) {
    cout << (a - b) << "\n";
  } else {
    cout << 0 << "\n";
  }

  return 0;
}