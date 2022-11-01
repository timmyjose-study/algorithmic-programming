#include <algorithm>
#include <cmath>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

struct CompSmallest {
  const vector<vector<int>> &a;

  CompSmallest(const vector<vector<int>> &a) : a(a) {}

  bool operator()(const pair<int, int> &p1, const pair<int, int> &p2) {
    return a[p1.first][p1.second] > a[p2.first][p2.second];
  }
};

// O(klogm) / O(m)
int kth_smallest_in_m_sorted_lists(const vector<vector<int>> &a, int k) {
  CompSmallest comp(a);
  priority_queue<pair<int, int>, vector<pair<int, int>>, CompSmallest> min_heap(
      comp);

  for (int i = 0; i < a.size(); i++) {
    min_heap.push(make_pair<>(i, 0));
  }

  while (k > 1) {
    auto p = min_heap.top();
    min_heap.pop();

    p.second++;
    if (p.second < a[p.first].size()) {
      min_heap.push(p);
    }
    k--;
  }

  auto res = min_heap.top();
  return a[res.first][res.second];
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, m, k, n;
  cin >> tt;

  while (tt--) {
    cin >> m >> k;

    vector<vector<int>> a(m);
    for (int i = 0; i < m; i++) {
      cin >> n;

      vector<int> v(n);
      for (int j = 0; j < n; j++) {
        cin >> v[j];
      }
      a[i] = v;
    }

    cout << kth_smallest_in_m_sorted_lists(a, k) << "\n";
  }

  return 0;
}