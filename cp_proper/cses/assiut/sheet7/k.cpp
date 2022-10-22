#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int max(const vector<int> &a, int curr_idx, int n, int max_val) {
  if (curr_idx == n) {
    return max_val;
  }

  if (a[curr_idx] > max_val) {
    return max(a, curr_idx + 1, n, a[curr_idx]);
  } else {
    return max(a, curr_idx + 1, n, max_val);
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  cout << max(a, 0, n, a[0]) << "\n";

  return 0;
}