#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int collatz_length(int n) {
  if (n == 1) {
    return 1;
  }
  return 1 + (n % 2 == 0 ? collatz_length(n / 2) : collatz_length(3 * n + 1));
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;
  cout << collatz_length(n) << "\n";

  return 0;
}