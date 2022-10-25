#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(nlogn) / O(n)
int kth_largest(vector<int> &a, int k) {
  sort(a.rbegin(), a.rend());
  return a[k - 1];
}

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

    cout << kth_largest(a, k) << "\n";
  }

  return 0;
}