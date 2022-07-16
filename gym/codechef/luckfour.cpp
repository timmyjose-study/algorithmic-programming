#include <iostream>

using namespace std;

int main() {
  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    int c = 0;
    while (n) {
      if (n % 10 == 4) {
        c++;
       }
      n /= 10;
     }
     cout << c << "\n";
   }

   return 0;
}


