#include <iostream>
#include <vector>

using namespace std;

int main() {
  int tt, n, m, k;

  cin >> tt;
  while (tt--) {
    cin >> n >> m >> k;

    int d;
    vector<int> a;
    int score = 0;
    for (int i = 0; i < n; i++) {
      cin >> d;
      a.push_back(d);
    }

    bool valid = true;
    for (int i = 0; i < m; i++) {
      if (!a[i]) {
        valid = false;
        break;
      }
    }

    if (valid) {
      score = k;

      for (int j = m; j < n; j++) {
        if (!a[j]) {
          valid = false;
          break;
        }
      }

      if (valid) {
        score = 100;
      }
    }

    cout << score << "\n";
  }

  return 0;
}