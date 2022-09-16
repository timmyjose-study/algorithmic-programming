#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, k;
  cin >> n >> k;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  sort(a.begin(), a.end(), greater<int>());

  long long max = 0;
  for (int i = 0; i < k; i++) {
    if (a[i] < 0) {
      continue;
    }
    max += a[i];
  }

  cout << max << "\n";

  return 0;
}