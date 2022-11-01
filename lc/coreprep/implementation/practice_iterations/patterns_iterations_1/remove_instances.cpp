#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n) / O(1)
int remove_instances(vector<int> &a, int k) {
  int next_pos = 0;
  for (int i = 0; i < a.size(); i++) {
    if (a[i] != k) {
      a[next_pos++] = a[i];
    }
  }

  return next_pos;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    int len = remove_instances(a, k);
    cout << len << "\n";
    for (int i = 0; i < len; i++) {
      cout << a[i] << " ";
    }
    cout << "\n";
  }

  return 0;
}