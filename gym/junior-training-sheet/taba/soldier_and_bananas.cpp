#include <iostream>

using namespace std;

int main() {
  int n, k, w;

  cin >> k >> n >> w;

  int cost = k * (w * (w + 1) / 2);

  if (cost <= n) {
    cout << 0 << "\n";
  } else {
    cout << (cost - n) << "\n";
  }

  return 0;
}