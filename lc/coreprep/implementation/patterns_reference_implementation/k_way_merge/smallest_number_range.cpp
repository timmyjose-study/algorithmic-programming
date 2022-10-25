#include <algorithm>
#include <iostream>
#include <limits>
#include <queue>
#include <vector>

using namespace std;

struct Entry {
  int list_idx;
  int arr_idx;

  Entry(int list_idx, int arr_idx) : list_idx(list_idx), arr_idx(arr_idx) {}
};

struct CompareEntry {
  const vector<vector<int>> &lists;

  CompareEntry(const vector<vector<int>> &lists) : lists(lists) {}

  bool operator()(const Entry &e1, const Entry &e2) {
    return lists[e1.list_idx][e1.arr_idx] > lists[e2.list_idx][e2.arr_idx];
  }
};

// O(nlogm) / O(m)
pair<int, int> smallest_number_range(const vector<vector<int>> &lists) {
  CompareEntry comp(lists);
  priority_queue<Entry, vector<Entry>, CompareEntry> min_heap(comp);

  int curr_start = 0, curr_end = numeric_limits<int>::max();
  int curr_max = numeric_limits<int>::min();
  for (int i = 0; i < lists.size(); i++) {
    min_heap.push(Entry(i, 0));
    curr_max = max(curr_max, lists[i][0]);
  }

  while (min_heap.size() == lists.size()) {
    Entry entry = min_heap.top();
    min_heap.pop();

    if (curr_max - lists[entry.list_idx][entry.arr_idx] <
        curr_end - curr_start) {
      curr_start = lists[entry.list_idx][entry.arr_idx];
      curr_end = curr_max;
    }

    entry.arr_idx++;

    if (entry.arr_idx < lists[entry.list_idx].size()) {
      min_heap.push(entry);
      curr_max = max(curr_max, lists[entry.list_idx][entry.arr_idx]);
    }
  }

  return make_pair<>(curr_start, curr_end);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, m, n;
  cin >> tt;

  while (tt--) {
    cin >> m;

    vector<vector<int>> lists;
    for (int i = 0; i < m; i++) {
      cin >> n;

      vector<int> a(n);
      for (int j = 0; j < n; j++) {
        cin >> a[j];
      }
      lists.emplace_back(a);
    }

    auto [start, end] = smallest_number_range(lists);
    cout << start << " " << end << "\n";
  }

  return 0;
}