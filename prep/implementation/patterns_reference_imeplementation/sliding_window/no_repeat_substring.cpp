#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> s;

    int n = s.size();
    int max_len = 0, window_start = 0;
    unordered_map<char, int> pos;

    for (int window_end = 0; window_end < n; window_end++) {
      char c = s[window_end];

      if (pos.find(c) != pos.end()) {
        window_start = max(window_start, pos[c] + 1);
      }
      pos[c] = window_end;
      max_len = max(max_len, window_end - window_start + 1);
    }

    cout << max_len << "\n";
  }

  return 0;
}