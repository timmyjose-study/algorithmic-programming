#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void display(const vector<int> &a) {
  for (int e : a) {
    cout << e << " ";
  }
  cout << "\n";
}

void sort(vector<int> &a, int n) {
  int minval = a[0], maxval = a[0];
  for (int i = 1; i < n; i++) {
    minval = min(minval, a[i]);
    maxval = max(maxval, a[i]);
  }

  int k = abs(maxval - minval) + 1;
  vector<int> b(k);

  for (int e : a) {
    b[e - minval]++;
  }

  int idx = 0;
  for (int i = 0; i < k; i++) {
    int f = b[i];
    while (f--) {
      a[idx++] = i + minval;
    }
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

  display(a);
  sort(a, n);
  display(a);

  return 0;
}