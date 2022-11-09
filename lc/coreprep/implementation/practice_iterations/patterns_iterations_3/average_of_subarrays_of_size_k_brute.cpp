#include <algorithm>
#include <iomanip>
#include <iostream>
#include <vector>

using namespace std;

// O(nk) / O(1)
vector<double> averages(const vector<int> &a, int k) {
  int n = a.size();
  vector<double> res(n - k + 1);

  for (int i = 0; i < n - k + 1; i++) {
    int sum = 0;
    for (int j = i; j < i + k; j++) {
      sum += a[j];
    }
    res[i] = (double)sum / (double)k;
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = averages(a, k);
    for (double r : res) {
      cout << fixed << setprecision(1) << r << " ";
    }
    cout << "\n";
  }

  return 0;
}