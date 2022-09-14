#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

string dec2bin(int n) {
  if (!n) {
    return "0";
  }

  string bin = "";
  while (n) {
    bin += n % 2 + '0';
    n >>= 1;
  }

  for (int i = 0, j = bin.size() - 1; i < j; i++, j--) {
    char c = bin[i];
    bin[i] = bin[j];
    bin[j] = c;
  }

  return bin;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << dec2bin(n) << "\n";
  }

  return 0;
}