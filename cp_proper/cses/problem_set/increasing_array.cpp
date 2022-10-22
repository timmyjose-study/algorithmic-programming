#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  long long curr_max = -1, sol = 0, d;
  for (int i = 0; i < n; i++) {
    cin >> d;
    if (curr_max == -1) {
      curr_max = d;
    } else {
      if (d > curr_max) {
        curr_max = d;
      } else {
        sol += (curr_max - d);
      }
    }
  }

  cout << sol << "\n";

  return 0;
}