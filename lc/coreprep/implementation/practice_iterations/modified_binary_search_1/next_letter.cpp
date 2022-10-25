#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

// O(logn) / O(1)
char next_letter(const string &s, char k) {
  if (k < s[0] || k == s[s.size() - 1]) {
    return s[0];
  }

  int low = 0, high = s.size() - 1;
  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (s[mid] <= k) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }

  return s[low % s.size()];
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string s;
  char k;

  cin >> tt;
  cin.ignore(1, '\n');

  while (tt--) {
    cin >> s >> k;
    cout << next_letter(s, k) << "\n";
  }

  return 0;
}