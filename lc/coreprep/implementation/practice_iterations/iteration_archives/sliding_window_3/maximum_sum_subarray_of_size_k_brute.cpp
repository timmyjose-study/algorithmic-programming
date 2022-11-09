#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n * k)/ O(1)
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

    int max_sum = 0;
    for (int i = 0; i < n - k + 1; i++) {
      int sum = 0;
      for (int j = i; j < i + k; j++) {
        sum += a[j];
      }
      max_sum = max(max_sum, sum);
    }

    cout << max_sum << "\n";
  }

  return 0;
}