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
  int zc = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];

    if (!a[i]) {
      zc++;
    }
  }

  vector<int> b;
  for (int i = 0; i < n; i++) {
    if (a[i]) {
      b.emplace_back(a[i]);
    }
  }

  for (int i = 0; i < zc; i++) {
    b.emplace_back(0);
  }

  for (int e : b) {
    cout << e << " ";
  }
  cout << "\n";

  return 0;
}