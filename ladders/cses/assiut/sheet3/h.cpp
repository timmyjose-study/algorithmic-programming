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

  for (int i = 0; i < n - 1; i++) {
    int min_pos = i;

    for (int j = i + 1; j < n; j++) {
      if (a[j] < a[min_pos]) {
        min_pos = j;
      }
    }

    if (min_pos != i) {
      int t = a[min_pos];
      a[min_pos] = a[i];
      a[i] = t;
    }
  }
  for (int e : a) {
    cout << e << " ";
  }
  cout << "\n";

  return 0;
}