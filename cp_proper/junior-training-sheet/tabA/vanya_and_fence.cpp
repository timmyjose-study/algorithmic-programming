#include <iostream>

using namespace std;

int main() {
  int n, m, h;
  int w = 0;

  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> h;
    w += h > m ? 2 : 1;
  }

  cout << w << "\n";

  return 0;
}