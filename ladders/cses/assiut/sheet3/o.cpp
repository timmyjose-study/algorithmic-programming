#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  int cnt = 1;
  unsigned long long a = 0, b = 1, c;
  while (cnt < n) {
    cnt++;
    c = a + b;
    a = b;
    b = c;
  }

  cout << a << "\n";

  return 0;
}