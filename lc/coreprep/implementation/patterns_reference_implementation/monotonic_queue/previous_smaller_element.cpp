#include <algorithm>
#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>

using namespace std;

// O(n) / O(n)
vector<int> previous_smaller_element(const vector<int> &a) {
  unordered_map<int, int> mapping;
  for (int i = 0; i < a.size(); i++) {
    mapping[i] = -1;
  }

  deque<int> q;
  for (int i = 0; i < a.size(); i++) {
    while (!q.empty() && a[i] < a[q.back()]) {
      q.pop_back();
    }

    if (!q.empty()) {
      mapping[i] = q.back();
    }
    q.push_back(i);
  }

  vector<int> res(a.size());
  for (int i = 0; i < a.size(); i++) {
    int idx = mapping[i];

    if (idx == -1) {
      res[i] = -1;
    } else {
      res[i] = a[idx];
    }
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = previous_smaller_element(a);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}