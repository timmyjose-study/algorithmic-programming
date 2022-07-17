#include <iostream>

using namespace std;

int main() {
  int tt, n, k, d;

  cin >> tt;
  while (tt--) {
    cin >> n >> k;

    unsigned long long sum = 0ULL;
    for (int i = 0; i < n; i++) {
      cin >> d;
      sum += (unsigned long long)d;
    }

    cout << (sum % k) << "\n";
  }
}