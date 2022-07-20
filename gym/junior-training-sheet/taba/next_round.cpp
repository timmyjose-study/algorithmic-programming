#include <array>
#include <iostream>

using namespace std;

const int N = 100;

int main() {
  int n, k;
  array<int, N> a;

  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  int cnt = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] >= a[k - 1] && a[i] > 0) {
      cnt++;
    }
  }

  cout << cnt << "\n";

  return 0;
}