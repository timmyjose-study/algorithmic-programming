#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void printn(int n, char c) {
  for (int i = 0; i < n; i++) {
    cout << c << " ";
  }
  cout << "\n";
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  char c;
  cin >> tt;

  while (tt--) {
    cin >> n >> c;
    printn(n, c);
  }

  return 0;
}