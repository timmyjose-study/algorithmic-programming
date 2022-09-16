#include <iostream>
#include <limits>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, k, d;
  cin >> n >> k;

  int min_val = numeric_limits<int>::max();

  int cnt = 0;
  for (int i = 0; i < n; i++) {
    cin >> d;
    cnt++;
    min_val = min(min_val, d);

    if (cnt == k || i == n - 1) {
      cout << min_val << " ";
      cnt = 0;
      min_val = numeric_limits<int>::max();
    }
  }
  cout << "\n";

  return 0;
}