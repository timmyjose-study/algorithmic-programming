#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  cin >> tt;

  unsigned long long n, s;

  while (tt--) {
    cin >> n >> s;

    if ((n * (n + 1)) / 2 < s) {
      cout << -1 << "\n";
    } else {
      unsigned long long tot = 0ULL;
      vector<unsigned long long> a;

      for (unsigned long long m = n; n >= 1; m--) {
        if (m + tot <= s) {
          tot += m;
          a.push_back(m);
        }

        if (tot == s) {
          break;
        }
      }

      for (auto c : a) {
        cout << c << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}