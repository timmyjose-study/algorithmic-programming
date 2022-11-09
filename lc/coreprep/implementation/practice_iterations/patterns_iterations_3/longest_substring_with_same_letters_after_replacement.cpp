#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

// O(n) / O(1)
int longest_substring_with_same_letters_after_k_replacements(const string &s,
                                                             int k) {
  unordered_map<char, int> freq;
  int max_freq = 0, max_len = 0, window_start = 0;

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
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, k;
  string s;

  cin >> tt;
  cin.ignore(1, '\n');

  while (tt--) {
    cin >> s >> k;
    cout << longest_substring_with_same_letters_after_k_replacements(s, k)
         << "\n";
  }

  return 0;
}