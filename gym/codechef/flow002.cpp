#include <iostream>

using namespace std;

int main() {
  int tt, n, d;

  cin >> tt;
  while (tt--) {
    cin >> n >> d;
    cout << (n % d) << "\n";
   }

   return 0;
}