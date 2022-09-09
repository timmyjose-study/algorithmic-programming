#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int kk, s;
  int cnt = 0;

  cin >> kk >> s;
  for (int i = 0; i <= kk; i++) {
    for (int j = 0; j <= kk; j++) {
      if (s - (i + j) >= 0 && s - (i + j) <= kk) {
        cnt++;
      }
    }
  }

  cout << cnt << "\n";

  return 0;
}