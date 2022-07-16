#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, k, d;
  cin >> n >> k;

  int sol = 0;
  while (n--) {
    cin >> d;
    if (d % k == 0) {
      sol++;
     }
   }

   cout << sol << endl;

   return 0;
 }
