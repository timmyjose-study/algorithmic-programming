#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

unsigned long long log2(unsigned long long n) {
  if (n == 1) {
    return 0;
  }

  return 1 + log2(n / 2);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n;
  cin >> n;
  cout << log2(n) << "\n";

  return 0;
}