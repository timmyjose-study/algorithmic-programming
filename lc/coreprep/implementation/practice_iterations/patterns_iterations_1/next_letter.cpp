#include <algorithm>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

// O(logn) / O(1)
char next_letter(const string &a, int k) {
  int low = 0, high = a.size() - 1;

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] <= k) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }

  return a[low % a.size()];
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  string a;
  char k;

  cin >> tt;
  cin.ignore(1, '\n');

  while (tt--) {
    cin >> a >> k;
    cout << next_letter(a, k) << "\n";
  }

  return 0;
}