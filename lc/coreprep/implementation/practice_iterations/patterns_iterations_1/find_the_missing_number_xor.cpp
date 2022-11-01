#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n) / O(1)
int missing_number_xor(const vector<int> &a) {
  int xor1 = 0;
  for (int e : a) {
    xor1 ^= e;
  }

  int xor2 = 0;
  for (int i = 1; i <= a.size() + 1; i++) {
    xor2 ^= i;
  }

  return xor1 ^ xor2;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n - 1);
    for (int i = 0; i < n - 1; i++) {
      cin >> a[i];
    }

    cout << missing_number_xor(a) << "\n";
  }

  return 0;
}