#include <iostream>

using namespace std;

int main() {
  int tt, sol = 0, k;
  long long m;

  cin >> tt >> m >> k;
  while (tt--) {
    long long mins = 0LL;
    int d, q;
    for (int i = 0; i < k; i++) {
      cin >> d;
      mins += (long long)d;
    }

    cin >> q;
    if (mins >= m && q <= 10) {
      sol++;
    }
  }

  cout << sol << "\n";

  return 0;
}