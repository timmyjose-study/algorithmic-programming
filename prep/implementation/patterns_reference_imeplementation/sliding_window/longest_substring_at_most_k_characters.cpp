#include <algorithm>
#include <iostream>
#include <limits>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, k;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> s;
    cin.ignore(1);
    cin >> k;

    int n = s.size();
    unordered_map<char, int> m;
    int max_len = 0;
    int window_start = 0;

    for (int window_end = 0; window_end < n; window_end++) {
      char c = s[window_end];
      if (m.find(c) != m.end()) {
        m[c]++;
      } else {
        m[c] = 1;
      }

      while (m.size() > k) {
        char d = s[window_start];
        m[d]--;
        if (m[d] == 0) {
          m.erase(d);
        }
        window_start++;
      }

      max_len = max(max_len, window_end - window_start + 1);
    }

    cout << max_len << "\n";
  }

  return 0;
}