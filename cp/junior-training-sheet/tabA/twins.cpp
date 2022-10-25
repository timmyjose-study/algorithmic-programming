#include <algorithm>
#include <iostream>
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

  sort(a.begin(), a.end(), [](auto x, auto y) { return x > y; });

  int tot = 0;
  for (int e : a) {
    tot += e;
  }

  int s = 0, cnt = 0;
  for (int e : a) {
    if (s > tot - s) {
      break;
    }
    s += e;
    cnt++;
  }

  cout << cnt << "\n";

  return 0;
}