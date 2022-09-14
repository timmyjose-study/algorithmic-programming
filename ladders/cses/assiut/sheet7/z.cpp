#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void left_max(const vector<int> &a, int curr_idx, int n, int curr_max) {
  if (curr_idx == n) {
    cout << "\n";
    return;
  }

  cout << curr_max << " ";
  left_max(a, curr_idx + 1, n,
           a[curr_idx + 1] > curr_max ? a[curr_idx + 1] : curr_max);
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

  left_max(a, 0, n, a[0]);

  return 0;
}