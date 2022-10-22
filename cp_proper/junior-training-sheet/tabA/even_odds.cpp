#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  long long n, k;

  cin >> n >> k;

  long long no = n - n / 2;

  if (k <= no) {
    cout << (1 + (k - 1) * 2) << "\n";
  } else {
    k = k - no;
    cout << (2 + (k - 1) * 2) << "\n";
  }

  return 0;
}