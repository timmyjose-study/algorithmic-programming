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

  int d = n - 1;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < d; j++) {
      cout << " ";
    }

    for (int j = 0; j < 2 * (n - d) - 1; j++) {
      cout << "*";
    }

    cout << "\n";
    d--;
  }

  return 0;
}