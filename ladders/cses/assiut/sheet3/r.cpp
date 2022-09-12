#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n), b(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  sort(a.begin(), a.end());

  for (int i = 0; i < n; i++) {
    cin >> b[i];
  }

  sort(b.begin(), b.end());

  for (int i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      cout << "no\n";
      return 0;
    }
  }

  cout << "yes\n";

  return 0;
}