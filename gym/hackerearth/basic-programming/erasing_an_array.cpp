#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> n;

    int curr, next;
    int sol = 1;
    cin >> curr;
    for (int i = 1; i < n; i++) {
      cin >> next;
      if (curr == 0 && next == 1) {
        curr = next;
      } else if (curr == 1 && next == 0) {
        sol++;
        curr = next;
      }
    }
    cout << sol << "\n";
  }

  return 0;
}