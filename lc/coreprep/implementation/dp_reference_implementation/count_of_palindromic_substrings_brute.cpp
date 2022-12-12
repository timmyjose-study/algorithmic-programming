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

bool is_palindrome(const string &s, int start_idx, int end_idx) {
  while (start_idx < end_idx) {
    if (s[start_idx] != s[end_idx]) {
      return false;
    }
    start_idx++;
    end_idx--;
  }
  return true;
}

int count_palidromes(const string &s, int start_idx, int end_idx) {
  if (start_idx > end_idx) {
    return 0;
  }

  if (start_idx == end_idx) {
    return 1;
  }

  int cnt = 0;
  if (is_palindrome(s, start_idx, end_idx)) {
    cnt++;
  }

  cnt += count_palidromes(s, start_idx + 1, end_idx);
  cnt += count_palidromes(s, start_idx, end_idx - 1);
  cnt -= count_palidromes(s, start_idx + 1, end_idx - 1);

  return cnt;
}

// O(3n) / O(n)
int count_palidromes(const string &s) {
  if (s.empty()) {
    return 0;
  }

  return count_palidromes(s, 0, s.size() - 1);
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
    cout << count_palidromes(s) << "\n";
  }

  return 0;
}