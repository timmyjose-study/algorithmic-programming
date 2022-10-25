#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto setcount = [](unsigned int n) {
    int cnt = 0;
    while (n) {
      cnt += n & 1;
      n >>= 1;
    }
    return cnt;
  };

  auto bin2dec = [](int n) {
    int val = 0;
    while (n--) {
      val = 2 * val + 1;
    }
    return val;
  };

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << bin2dec(setcount(n)) << "\n";
  }

  return 0;
}