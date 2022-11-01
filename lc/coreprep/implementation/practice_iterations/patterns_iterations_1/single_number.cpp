#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n) / O(1)
int single_number(const vector<int> &a) {
  int x = 0;
  for (int e : a) {
    x ^= e;
  }

  return x;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << single_number(a) << "\n";
  }

  return 0;
}