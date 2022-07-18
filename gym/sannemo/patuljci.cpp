#include <algorithm>
#include <array>
#include <iostream>

using namespace std;

const int N = 20;

int main() {
  int s = 0;
  array<int, N> a;

  a.fill(0);

  for (int i = 0; i < 9; i++) {
    cin >> a[i];
    s += a[i];
  }

  int diff = s - 100;
  int pos1 = -1, pos2 = -1;
  for (int i = 0; i < 9; i++) {
    for (int j = i + 1; j < 9; j++) {
      if ((i != j) && (a[i] + a[j] == diff)) {
        pos1 = i;
        pos2 = j;
        break;
      }
    }
  }

  for (int i = 0; i < 9; i++) {
    if (i == pos1 || i == pos2) {
      continue;
    }
    cout << a[i] << "\n";
  }

  return 0;
}