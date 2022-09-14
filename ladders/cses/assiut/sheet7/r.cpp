#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool is_palindrome(const vector<int> &a, int i, int j) {
  if (i >= j) {
    return true;
  }

  return (a[i] == a[j] ? is_palindrome(a, i + 1, j - 1) : false);
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

  cout << (is_palindrome(a, 0, n - 1) ? "YES" : "NO") << "\n";

  return 0;
}