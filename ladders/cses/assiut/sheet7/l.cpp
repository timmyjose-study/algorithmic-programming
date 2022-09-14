#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

long long sum(const vector<int> &a, int curr_idx, int n) {
  if (curr_idx == n) {
    return 0;
  }

  return (long long)a[curr_idx] + sum(a, curr_idx + 1, n);
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

  cout << sum(a, 0, n) << "\n";

  return 0;
}