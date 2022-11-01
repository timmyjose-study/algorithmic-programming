#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

// O(b) / O(1)
int complement(unsigned n) {
  auto count_bits = [](unsigned m) {
    int cnt = 0;
    while (m) {
      cnt++;
      m >>= 1;
    }

    return cnt;
  };

  int nbits = count_bits(n);
  int mask = round(pow(2, nbits)) - 1;

  return n ^ mask;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  unsigned n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << complement(n) << "\n";
  }

  return 0;
}