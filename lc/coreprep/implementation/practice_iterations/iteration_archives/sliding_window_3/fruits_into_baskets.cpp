#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

// O(n) / O(1)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> n;

    vector<char> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    unordered_map<char, int> freq;
    int max_len = 0, window_start = 0;

    for (int window_end = 0; window_end < n; window_end++) {
      char r = a[window_end];

      if (freq.find(r) == freq.end()) {
        freq[r] = 1;
      } else {
        freq[r]++;
      }

      while (freq.size() > 2) {
        char l = a[window_start];
        freq[l]--;

        if (freq[l] == 0) {
          freq.erase(l);
        }
        window_start++;
      }
      max_len = max(max_len, window_end - window_start + 1);
    }
    cout << max_len << "\n";
  }

  return 0;
}