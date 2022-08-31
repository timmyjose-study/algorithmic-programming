#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, h, g;

  cin >> n;
  vector<pair<int, int>> a(n);
  for (int i = 0; i < n; i++) {
    cin >> h >> g;
    a[i] = make_pair(h, g);
  }

  sort(a.begin(), a.end());

  int sol = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (i == j) {
        continue;
      }
      if (a[i].first == a[j].second) {
        sol++;
      }
    }
  }

  cout << sol << "\n";

  return 0;
}