#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, d;

  cin >> n;
  vector<int> a(n);

  for (int i = 0; i < n; i++) {
    cin >> d;
    a[i] = d;
  }

  int nq, pos, m;

  cin >> nq;
  while (nq--) {
    cin >> m >> pos;
    m--;
    pos--;

    int left = pos;
    if (m > 0) {
      a[m - 1] += left;
    }

    int right = a[m] - pos - 1;
    if (m < n - 1) {
      a[m + 1] += right;
    }

    a[m] = 0;
  }

  for (int b : a) {
    cout << b << "\n";
  }

  return 0;
}