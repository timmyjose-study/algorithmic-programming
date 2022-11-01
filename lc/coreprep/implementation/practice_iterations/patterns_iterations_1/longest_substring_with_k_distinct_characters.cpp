#include <algorithm>
#include <iostream>
#include <limits>
#include <unordered_map>
#include <vector>

using namespace std;

// O(n) / O(k)
int longest_substring(string &s, int k) {
  unordered_map<char, int> freq;
  int max_len = numeric_limits<int>::min();
  int window_start = 0;

  for (int window_end = 0; window_end < s.size(); window_end++) {
    char r = s[window_end];
    if (freq.find(r) == freq.end()) {
      freq[r] = 1;
    } else {
      freq[r]++;
    }

    while (freq.size() > k) {
      char l = s[window_start];
      freq[l]--;

      if (freq[l] == 0) {
        freq.erase(l);
      }
      window_start++;
    }
    max_len = max(max_len, window_end - window_start + 1);
  }

  return max_len;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, k;
  string s;

  cin >> tt;
  cin.ignore(1, '\n');
  while (tt--) {
    cin >> s >> k;
    cout << longest_substring(s, k) << "\n";
  }

  return 0;
}