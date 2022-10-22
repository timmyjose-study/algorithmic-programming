#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void concatenate(const vector<int> &a, const vector<int> &b, vector<int> &c) {
  for (int e : b) {
    c.emplace_back(e);
  }

  for (int e : a) {
    c.emplace_back(e);
  }
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

  vector<int> b(n);
  for (int i = 0; i < n; i++) {
    cin >> b[i];
  }

  vector<int> c;
  concatenate(a, b, c);

  for (int e : c) {
    cout << e << " ";
  }
  cout << "\n";

  return 0;
}