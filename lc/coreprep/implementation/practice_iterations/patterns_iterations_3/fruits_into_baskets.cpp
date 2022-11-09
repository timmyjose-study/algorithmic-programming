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

// O(n) / O(n)
int max_fruits(const vector<char> &a) {
  unordered_map<char, int> freq;
  int max_len = numeric_limits<int>::min();
  int window_start = 0;

  for (int window_end = 0; window_end < a.size(); window_end++) {
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

  return max_len;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;

  cin >> tt;
  while (tt--) {
    cin >> n;
    cin.ignore(1, '\n');

    vector<char> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << max_fruits(a) << "\n";
  }

  return 0;
}