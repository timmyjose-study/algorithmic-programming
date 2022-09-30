#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, k;
  string s;

  cin >> tt;
  cin.ignore(1);
  while (tt--) {
    cin >> s;
    cin >> k;

    int n = s.size();
    int max_len = 0, window_start = 0;
    unordered_map<char, int> freq;
    int max_letter_freq = 0;

    for (int window_end = 0; window_end < n; window_end++) {
      char c = s[window_end];

      if (freq.find(c) == freq.end()) {
        freq[c] = 1;
      } else {
        freq[c]++;
      }

      max_letter_freq = max(max_letter_freq, freq[c]);

      if (window_end - window_start + 1 - max_letter_freq > k) {
        char d = s[window_start];
        freq[d]--;
        window_start++;
      }
      max_len = max(max_len, window_end - window_start + 1);
    }

    cout << max_len << "\n";
  }

  return 0;
}