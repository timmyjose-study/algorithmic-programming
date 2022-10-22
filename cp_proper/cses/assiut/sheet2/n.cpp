#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  char c;
  int n, d;

  cin >> c >> n;
  for (int i = 0; i < n; i++) {
    cin >> d;
    for (int j = 0; j < d; j++) {
      cout << c;
    }
    cout << "\n";
  }

  return 0;
}