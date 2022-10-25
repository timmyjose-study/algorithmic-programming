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

// O(nlogk) / O(k)
vector<int> merge_k_sorted_arrays(const vector<vector<int>> &lists) {
  CompareEntry comp(lists);
  priority_queue<Entry, vector<Entry>, CompareEntry> min_heap(comp);

  for (int i = 0; i < lists.size(); i++) {
    min_heap.push(Entry(i, 0));
  }

  vector<int> res;
  while (!min_heap.empty()) {
    Entry entry = min_heap.top();
    min_heap.pop();

    res.push_back(lists[entry.list_idx][entry.arr_idx]);

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

  int tt, k, n;
  cin >> tt;

  while (tt--) {
    cin >> k;

    vector<vector<int>> lists;
    for (int i = 0; i < k; i++) {
      cin >> n;

      vector<int> a(n);
      for (int j = 0; j < n; j++) {
        cin >> a[j];
      }
      lists.emplace_back(a);
    }

    auto merged = merge_k_sorted_arrays(lists);
    for (int m : merged) {
      cout << m << " ";
    }
    cout << "\n";
  }

  return 0;
}