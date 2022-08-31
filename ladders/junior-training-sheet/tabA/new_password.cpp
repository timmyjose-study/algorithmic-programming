#include <iostream>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, d;
  cin >> n >> d;

  string p = "";
  int k = 0;
  for (int i = 0; i < n; i++) {
    p += 'a' + (k % d);
    k++;
  }

  cout << p << "\n";

  return 0;
}