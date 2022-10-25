#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct Entry {
  int list_idx;
  int arr_idx;

  Entry(int list_idx, int arr_idx) : list_idx(list_idx), arr_idx(arr_idx) {}
};

struct CompareEntry {
  const vector<vector<int>> &a;

  CompareEntry(const vector<vector<int>> &a) : a(a) {}

  bool operator()(const Entry &e1, const Entry &e2) {
    return a[e1.list_idx][e1.arr_idx] > a[e2.list_idx][e2.arr_idx];
  }
};

// O(klogm) / O(m)
int kth_smallest_number_in_m_sorted_lists(const vector<vector<int>> &lists,
                                          int k) {
  CompareEntry comp(lists);
  priority_queue<Entry, vector<Entry>, CompareEntry> min_heap(comp);

  for (int i = 0; i < lists.size(); i++) {
    min_heap.push(Entry(i, 0));
  }

  int res = -1;
  while (!min_heap.empty()) {
    Entry entry = min_heap.top();
    min_heap.pop();
    k--;

    if (k == 0) {
      res = lists[entry.list_idx][entry.arr_idx];
      break;
    }

    if (entry.arr_idx < lists[entry.list_idx].size() - 1) {
      entry.arr_idx++;
      min_heap.push(entry);
    }
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, m, n, k;
  cin >> tt;

  while (tt--) {
    cin >> m >> k;

    vector<vector<int>> lists;
    for (int i = 0; i < m; i++) {
      cin >> n;
      vector<int> a(n);
      for (int j = 0; j < n; j++) {
        cin >> a[j];
      }
      lists.emplace_back(a);
    }

    cout << kth_smallest_number_in_m_sorted_lists(lists, k) << "\n";
  }

  return 0;
}