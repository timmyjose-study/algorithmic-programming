#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

// O(n) / O(1)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> s;

    unordered_map<char, int> pos;
    int window_start = 0, max_len = 0;

    for (int window_end = 0; window_end < s.size(); window_end++) {
      char r = s[window_end];

      if (pos.find(r) != pos.end()) {
        window_start = max(window_start, pos[r] + 1);
      }
      pos[r] = window_end;
      max_len = max(max_len, window_end - window_start + 1);
    }

    cout << max_len << "\n";
  }

  return 0;
}