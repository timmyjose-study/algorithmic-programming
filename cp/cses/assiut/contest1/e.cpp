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

  if (!a && !b) {
    cout << "NO\n";
  } else {
    cout << (abs(a - b) <= 1 ? "YES" : "NO") << "\n";
  }

  return 0;
}