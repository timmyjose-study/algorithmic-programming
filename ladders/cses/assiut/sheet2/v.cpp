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

  int curr = 1;
  for (int i = 0; i < n; i++) {
    while (curr % 4) {
      cout << curr << " ";
      curr++;
    }
    cout << "PUM\n";
    curr++;
  }

  return 0;
}