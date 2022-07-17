#include <iostream>
#include <vector>

using namespace std;

const int N = 200;

int main() {
  int tt, n, p, x, y;

  cin >> tt;
  while (tt--) {
    cin >> n >> p >> x >> y;
    vector<int> a(N);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    int time = 0;
    for (int i = 0; i <= p - 1; i++) {
      time += (a[i] == 0 ? x : y);
    }

    cout << time << "\n";
  }

  return 0;
}