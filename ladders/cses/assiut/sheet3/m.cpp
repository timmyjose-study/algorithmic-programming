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

  int min_val = a[0], max_val = 0, min_pos = 0, max_pos = 0;
  for (int i = 1; i < n; i++) {
    if (a[i] < min_val) {
      min_pos = i;
      min_val = a[i];
    }

    if (a[i] > max_val) {
      max_pos = i;
      max_val = a[i];
    }
  }

  int t = a[min_pos];
  a[min_pos] = a[max_pos];
  a[max_pos] = t;

  for (int e : a) {
    cout << e << " ";
  }
  cout << "\n";

  return 0;
}