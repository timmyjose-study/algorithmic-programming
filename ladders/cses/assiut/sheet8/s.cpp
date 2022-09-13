#include <algorithm>
#include <iostream>
#include <set>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, k;
  cin >> n >> k;

  set<int> s;
  string str;
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    cin >> str;
    for (char c : str) {
      s.insert(c - '0');
    }

    bool valid = true;
    for (int j = 0; j <= k; j++) {
      if (s.find(j) == s.end()) {
        valid = false;
        break;
      }
    }

    if (valid) {
      cnt++;
    }
    s.clear();
  }

  cout << cnt << "\n";

  return 0;
}