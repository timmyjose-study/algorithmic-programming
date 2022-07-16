#include <iostream>

using namespace std;

int main() {
  int tt, n, k;

  cin >> tt;
  while (tt--) {
    cin >> n >> k;
    cout << (n < k || k == 0 ? n : n % k) << "\n";
  }

  return 0;
}