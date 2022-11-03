#include <algorithm>
#include <iostream>
#include <limits>
#include <queue>
#include <string>
#include <vector>

using namespace std;

struct CompSmallest {
  const vector<vector<int>> &a;

  CompSmallest(const vector<vector<int>> &a) : a(a) {}

  bool operator()(const pair<int, int> &p1, const pair<int, int> &p2) {
    return a[p1.first][p1.second] > a[p2.first][p2.second];
  }
};

// O(nlogm) / O(m)
pair<int, int> smallest_number_range(const vector<vector<int>> &a) {
  CompSmallest comp(a);
  priority_queue<pair<int, int>, vector<pair<int, int>>, CompSmallest> min_heap(
      comp);

  int start = 0, end = numeric_limits<int>::max();
  int curr_max = numeric_limits<int>::min();
  for (int i = 0; i < a.size(); i++) {
    min_heap.push(make_pair<>(i, 0));
    curr_max = max(curr_max, a[i][0]);
  }

  while (!min_heap.empty()) {
    auto p = min_heap.top();
    min_heap.pop();

    if (curr_max - a[p.first][p.second] < end - start) {
      start = a[p.first][p.second];
      end = curr_max;
    }
    p.second++;

    if (p.second >= a[p.first].size()) {
      break;
    } else {
      min_heap.push(p);
      curr_max = max(curr_max, a[p.first][p.second]);
    }
  }

  return make_pair<>(start, end);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, m, n;
  cin >> tt;

  while (tt--) {
    cin >> m;

    vector<vector<int>> a(m);
    for (int i = 0; i < m; i++) {
      cin >> n;

      vector<int> v(n);
      for (int j = 0; j < n; j++) {
        cin >> v[j];
      }

      a[i] = v;
    }

    auto [start, end] = smallest_number_range(a);
    cout << start << " " << end << "\n";
  }

  return 0;
}