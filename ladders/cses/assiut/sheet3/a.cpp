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

  long long s = 0LL, d;
  for (int i = 0; i < n; i++) {
    cin >> d;
    s += d;
  }

  cout << abs(s) << "\n";

  return 0;
}