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

// O(logn) / O(1)
char next_letter(const string &s, char c) {
  int low = 0, high = s.size() - 1;

  if (c < s[low] || c > s[high]) {
    return s[low];
  }

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (s[mid] <= c) {
      low = mid + 1;
    } else if (s[mid] > c) {
      high = mid - 1;
    }
  }

  return s[low % s.size()];
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;
  char c;

  cin >> tt;
  cin.ignore(1, '\n');
  while (tt--) {
    cin >> s >> c;
    cout << next_letter(s, c) << "\n";
  }

  return 0;
}