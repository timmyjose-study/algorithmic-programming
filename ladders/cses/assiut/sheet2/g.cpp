#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  auto factorial = [](unsigned long long n) {
    unsigned long long f = 1ULL;
    for (unsigned long long i = 1; i <= n; i++) {
      f *= i;
    }
    return f;
  };

  int n, d;
  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> d;
    cout << factorial(d) << "\n";
  }

  return 0;
}