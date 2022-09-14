#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void print_even_indices(const vector<int> &a, int curr_idx, int n) {
  if (curr_idx >= n) {
    return;
  }

  print_even_indices(a, curr_idx + 2, n);
  cout << a[curr_idx] << " ";
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

  print_even_indices(a, 0, n);
  cout << "\n";

  return 0;
}