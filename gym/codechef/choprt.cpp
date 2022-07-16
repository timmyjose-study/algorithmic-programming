#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, m;
  cin >> tt;

  while (tt--) {
    cin >> n >> m;
    cout << (n == m ? "=" : (n < m ? "<" : ">")) << "\n";
  }

  return 0;
}