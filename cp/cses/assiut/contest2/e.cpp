#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  unsigned long long n;
  cin >> n;

  unsigned long long row = n / 4;
  unsigned long long col = 0;

  if (row % 2 == 0) {
    col = n % 4;
  } else {
    col = 3 - n % 4;
  }

  cout << row << " " << col << "\n";

  return 0;
}