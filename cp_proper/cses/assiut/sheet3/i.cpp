#include <iostream>
#include <limits>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  long long d;
  vector<long long> a;
  cin >> tt;

  while (tt--) {
    cin >> n;
    for (int i = 0; i < n; i++) {
      cin >> d;
      a.emplace_back(d);
    }

    long long min_val = numeric_limits<long long>::max();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (a[i] + a[j] + j - i < min_val) {
          min_val = a[i] + a[j] + j - i;
        }
      }
    }

    cout << min_val << "\n";
    a.clear();
  }

  return 0;
}