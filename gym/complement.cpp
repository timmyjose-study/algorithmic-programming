#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int highest_set_bit(unsigned int n) {
  for (int i = 31; i >= 0; i--) {
    if (n & (1 << i)) {
      return i;
    }
  }
  return -1;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned int n;
  cin >> n;
  int pos = highest_set_bit(n) + 1;
  int mask = ~(1 << pos);
  cout << (~n & mask) << "\n";

  return 0;
}