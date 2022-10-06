#include <algorithm>
#include <iomanip>
#include <iostream>
#include <vector>

using namespace std;

// O*(n * k) / O(1)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    vector<double> res(n - k + 1);
    for (int i = 0; i < n - k + 1; i++) {
      double sum = 0.0;
      for (int j = i; j < i + k; j++) {
        sum += a[j];
      }
      res[i] = sum / k;
    }

    for (double r : res) {
      cout << fixed << setprecision(1) << r << " ";
    }
    cout << "\n";
  }

  return 0;
}