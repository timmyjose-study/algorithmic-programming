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

  vector<int> a(n + 1);
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }

  vector<int> dist(2 * n + 2, 0);

  for (int i = 1; i <= n; i++) {
    if (dist[2 * i] == 0) {
      dist[2 * i] = dist[a[i]] + 1;
    }

    if (dist[2 * i + 1] == 0) {
      dist[2 * i + 1] = dist[a[i]] + 1;
    }
  }

  for (int i = 1; i <= 2 * n + 1; i++) {
    cout << dist[i] << "\n";
  }

  return 0;
}