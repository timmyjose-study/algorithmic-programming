#include <iostream>

using namespace std;

int main() {
  int n, x, d, tot = 0;

  cin >> x >> n;
  tot = x;

  for (int i = 0; i < n; i++) {
    cin >> d;
    tot += x;
    tot -= d;
  }

  cout << tot << "\n";

  return 0;
}