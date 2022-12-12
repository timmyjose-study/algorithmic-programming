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

int max_cut(int length, const vector<int> &lengths, int curr_idx) {
  if (length == 0) {
    return 0;
  }

  if (curr_idx >= lengths.size()) {
    return numeric_limits<int>::min();
  }

  int ways1 = numeric_limits<int>::min();

  if (lengths[curr_idx] <= length) {
    int res = max_cut(length - lengths[curr_idx], lengths, curr_idx);

    if (res != numeric_limits<int>::min()) {
      ways1 = 1 + res;
    }
  }

  int ways2 = max_cut(length, lengths, curr_idx + 1);

  return max(ways1, ways2);
}

// O(nl) / O(nl)
int max_cut(int length, const vector<int> &lengths) {
  if (length == 0 || lengths.empty()) {
    return -1;
  }

  int res = max_cut(length, lengths, 0);
  return (res == numeric_limits<int>::min() ? -1 : res);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, length;
  cin >> tt;

  while (tt--) {
    cin >> n >> length;

    vector<int> lengths(n);
    for (int i = 0; i < n; i++) {
      cin >> lengths[i];
    }

    cout << max_cut(length, lengths) << "\n";
  }

  return 0;
}