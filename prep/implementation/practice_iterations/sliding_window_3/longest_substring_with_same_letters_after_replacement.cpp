#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

// O(n) / O(1)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, k;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> s >> k;

    unordered_map<char, int> freq;
    int max_len = 0, window_start = 0;
    int max_freq = 0;

    for (int window_end = 0; window_end < s.size(); window_end++) {
      char r = s[window_end];

      if (freq.find(r) == freq.end()) {
        freq[r] = 1;
      } else {
        freq[r]++;
      }

      max_freq = max(max_freq, freq[r]);

      while (window_end - window_start + 1 - max_freq > k) {
        char l = s[window_start];
        freq[l]--;
        window_start++;
      }

      max_len = max(max_len, window_end - window_start + 1);
    }

    cout << max_len << "\n";
  }

  return 0;
}