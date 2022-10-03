#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<char> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    int max_len = 0, window_start = 0;
    unordered_map<char, int> freq;

    for (int window_end = 0; window_end < n; window_end++) {
      char c = a[window_end];

      if (freq.find(c) == freq.end()) {
        freq[c] = 1;
      } else {
        freq[c]--;
      }

      while (freq.size() > 2) {
        char d = a[window_start];
        freq[d]--;

        if (freq[d] == 0) {
          freq.erase(d);
        }
        window_start++;
      }
      max_len = max(max_len, window_end - window_start + 1);
    }

    cout << max_len << "\n";
  }

  return 0;
}