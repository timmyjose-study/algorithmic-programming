#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto sum_of_digits = [](int n) {
    int s = 0;
    while (n) {
      s += n % 10;
      n /= 10;
    }
    return s;
  };

  int n, a, b;
  cin >> n >> a >> b;

  int sol = 0;
  for (int i = 1; i <= n; i++) {
    int s = sum_of_digits(i);
    if (s >= a && s <= b) {
      sol += i;
    }
  }

  cout << sol << "\n";

  return 0;
}