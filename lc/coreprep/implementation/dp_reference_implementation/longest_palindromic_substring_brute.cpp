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

int lpss(const string &s, int start_idx, int end_idx) {
  if (start_idx > end_idx) {
    return 0;
  }

  if (start_idx == end_idx) {
    return 1;
  }

  if (s[start_idx] == s[end_idx]) {
    int rem_len = end_idx - start_idx - 1;

    if (rem_len == lpss(s, start_idx + 1, end_idx - 1)) {
      return 2 + rem_len;
    }
  }

  int len1 = lpss(s, start_idx + 1, end_idx);
  int len2 = lpss(s, start_idx, end_idx - 1);

  return max(len1, len2);
}

// O(3n) / O(n)
int lpss(const string &s) {
  if (s.empty()) {
    return 0;
  }

  return lpss(s, 0, s.size() - 1);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;

  cin >> tt;
  cin.ignore(numeric_limits<int>::max(), '\n');
  while (tt--) {
    getline(cin, s);
    cout << lpss(s) << "\n";
  }

  return 0;
}