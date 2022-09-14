#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void draw_pyramid(int curr_idx, int n) {
  if (curr_idx > n) {
    return;
  }

  int nspaces = n - curr_idx;
  for (int i = 0; i < nspaces; i++) {
    cout << " ";
  }

  int nstars = 2 * curr_idx - 1;
  for (int i = 0; i < nstars; i++) {
    cout << "*";
  }
  cout << "\n";

  draw_pyramid(curr_idx + 1, n);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  draw_pyramid(1, n);

  return 0;
}