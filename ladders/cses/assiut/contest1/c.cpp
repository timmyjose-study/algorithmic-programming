#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  char c;
  cin >> c;
  cout << ((char)((c + 1 - 'a') % 26 + 'a')) << "\n";

  return 0;
}