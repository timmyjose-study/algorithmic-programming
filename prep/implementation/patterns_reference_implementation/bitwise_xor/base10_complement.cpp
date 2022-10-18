#include <algorithm>
#include <cmath>
#include <iostream>

using namespace std;

// O(b) / O(1)
int complement(unsigned int n) {
  int bit_count = 0;
  int num = n;

  while (num) {
    bit_count++;
    num >>= 1;
  }

  int all_set_bits = pow(2, bit_count) - 1;

  return n ^ all_set_bits;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    cout << complement(n) << "\n";
  }

  return 0;
}