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

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  for (int i = 0; i < n; i++) {
    if (a[i] == 0) {
      for (int j = i - 1, k = 0; j >= k; j--, k++) {
        int t = a[j];
        a[j] = a[k];
        a[k] = t;
      }
    }
  }

  for (int e : a) {
    cout << e << " ";
  }
  cout << "\n";

  return 0;
}