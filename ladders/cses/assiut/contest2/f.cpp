#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto check = [](unsigned long long n) {
    int cnt = 0;
    while (n) {
      if (n % 2 == 0) {
        cnt++;
        n >>= 1;
      } else {
        break;
      }
    }
    return cnt;
  };

  int n;
  unsigned long long d;

  cin >> n;

  int cnt = 0;
  for (int i = 0; i < n; i++) {
    cin >> d;
    cnt = max(cnt, check(d));
  }

  cout << cnt << "\n";

  return 0;
}