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

  for (int i = n - 1; i >= 0; i--) {
    for (int j = 0; j <= i; j++) {
      cout << "*";
    }
    cout << "\n";
  }

  return 0;
}