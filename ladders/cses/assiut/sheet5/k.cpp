#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void rotate(vector<int> &a, int n, int x) {
  for (int i = 0; i < (x % n); i++) {
    int last = a[n - 1];
    for (int i = n - 1; i > 0; i--) {
      a[i] = a[i - 1];
    }
    a[0] = last;
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, x;
  cin >> n >> x;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  rotate(a, n, x);

  for (int e : a) {
    cout << e << " ";
  }
  cout << "\n";

  return 0;
}