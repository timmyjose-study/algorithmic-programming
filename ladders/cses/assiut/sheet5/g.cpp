#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

unsigned int min(vector<unsigned int> &a, int n) {
  unsigned int min_val = a[0];
  for (int i = 1; i < n; i++) {
    if (a[i] < min_val) {
      min_val = a[i];
    }
  }
  return min_val;
}

unsigned int max(vector<unsigned int> &a, int n) {
  unsigned int max_val = a[0];
  for (int i = 1; i < n; i++) {
    if (a[i] > max_val) {
      max_val = a[i];
    }
  }
  return max_val;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<unsigned int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  cout << min(a, n) << " " << max(a, n) << "\n";

  return 0;
}