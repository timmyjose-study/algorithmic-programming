#include <algorithm>
#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>

using namespace std;

// O(n) / O(n)
vector<int> next_greater_element(const vector<int> &a) {
  int n = a.size();

  unordered_map<int, int> pos;
  for (int i = 0; i < n; i++) {
    pos[i] = -1;
  }

  deque<int> q;
  for (int i = 0; i < n; i++) {
    while (!q.empty() && a[i] > a[q.back()]) {
      pos[q.back()] = i;
      q.pop_back();
    }
    q.push_back(i);
  }

  vector<int> res(n);
  for (int i = 0; i < n; i++) {
    int idx = pos[i];

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

    auto res = next_greater_element(a);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}