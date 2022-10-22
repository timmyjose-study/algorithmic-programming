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

  int ny = n / 365;
  n -= ny * 365;

  int nm = n / 30;
  n -= nm * 30;

  int nd = n;

  cout << ny << " years"
       << "\n";

  cout << nm << " months"
       << "\n";

  cout << nd << " days"
       << "\n";

  return 0;
}