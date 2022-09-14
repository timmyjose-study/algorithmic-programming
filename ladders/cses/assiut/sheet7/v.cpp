#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool expression(vector<unsigned long long> const &a, int i, int n,
                unsigned long long curr_val, unsigned long long x) {
  if (i == n) {
    return curr_val == x;
  }

  return (expression(a, i + 1, n, curr_val + a[i], x) ||
          expression(a, i + 1, n, curr_val - a[i], x));
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  unsigned long long x;
  cin >> n >> x;

  vector<unsigned long long> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  cout << (expression(a, 1, n, a[0], x) ? "YES" : "NO") << "\n";

  return 0;
}