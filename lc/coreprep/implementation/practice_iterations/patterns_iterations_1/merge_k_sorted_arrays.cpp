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

struct CompMerge {
  const vector<vector<int>> &a;

  CompMerge(const vector<vector<int>> &a) : a(a) {}

  bool operator()(const pair<int, int> &p1, const pair<int, int> &p2) {
    return a[p1.first][p1.second] > a[p2.first][p2.second];
  }
};

// O(nlogk) / O(k)
vector<int> merge_k_sorted_arrays(const vector<vector<int>> &a, int k) {
  CompMerge comp(a);
  priority_queue<pair<int, int>, vector<pair<int, int>>, CompMerge> min_heap(
      comp);

  for (int i = 0; i < k; i++) {
    min_heap.push(make_pair<>(i, 0));
  }

  vector<int> res;
  while (!min_heap.empty()) {
    auto p = min_heap.top();
    min_heap.pop();

    res.push_back(a[p.first][p.second]);
    p.second++;

    if (p.second < a[p.first].size()) {
      min_heap.push(p);
    }
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, k, n;
  cin >> tt;

  while (tt--) {
    cin >> k;

    vector<vector<int>> a(k);
    for (int i = 0; i < k; i++) {
      cin >> n;

      vector<int> v(n);
      for (int j = 0; j < n; j++) {
        cin >> v[j];
      }

      a[i] = v;
    }

    auto merged = merge_k_sorted_arrays(a, k);
    for (int e : merged) {
      cout << e << " ";
    }
    cout << "\n";
  }

  return 0;
}