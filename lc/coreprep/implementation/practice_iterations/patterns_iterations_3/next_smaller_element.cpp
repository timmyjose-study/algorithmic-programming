#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

// O(n) / O(n)
vector<int> next_smaller_element(const vector<int> &a) {
  vector<int> res(a.size(), -1);

  deque<int> q;
  for (int i = 0; i < a.size(); i++) {
    while (!q.empty() && (a[i] < a[q.back()])) {
      res[q.back()] = a[i];
      q.pop_back();
    }
    q.push_back(i);
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = next_smaller_element(a);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}