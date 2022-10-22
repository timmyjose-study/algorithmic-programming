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

  vector<unsigned long long> a(n + 1);
  a[0] = 0;
  a[1] = 1;
  for (int i = 2; i <= n; i++) {
    a[i] = a[i - 1] + a[i - 2];
  }

  for (int i = 0; i < n; i++) {
    cout << a[i] << " ";
  }
  cout << "\n";

  return 0;
}