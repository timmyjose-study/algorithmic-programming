#include <algorithm>
#include <array>
#include <iostream>

using namespace std;

const int N = 10;

int main() {
  array<int, N> a;

  for (int i = 0; i < 4; i++) {
    cin >> a[i];
  }

  sort(a.begin(), a.begin() + 4);

  cout << (a[0] * a[2]) << "\n";

  return 0;
}