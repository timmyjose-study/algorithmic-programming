#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

struct Entry {
  int arr_idx;
  int elem_idx;

  Entry(int arr_idx, int elem_idx) : arr_idx(arr_idx), elem_idx(elem_idx) {}
};

struct SmallComp {
  const vector<vector<int>> &a;

  SmallComp(const vector<vector<int>> &a) : a(a) {}

  bool operator()(const Entry &e1, const Entry &e2) {
    return a[e1.arr_idx][e1.elem_idx] > a[e2.arr_idx][e2.elem_idx];
  }
};

// O(nlogm) / O(m)
pair<int, int> smallest_number_range(const vector<vector<int>> &a, int m) {
  SmallComp comp(a);
  priority_queue<Entry, vector<Entry>, SmallComp> min_heap(comp);

  int start = 0, end = numeric_limits<int>::max(),
      curr_max = numeric_limits<int>::min();

  for (int i = 0; i < m; i++) {
    min_heap.push(Entry(i, 0));
    curr_max = max(curr_max, a[i][0]);
  }

  while (!min_heap.empty()) {
    auto entry = min_heap.top();
    min_heap.pop();

    if (curr_max - a[entry.arr_idx][entry.elem_idx] < end - start) {
      start = a[entry.arr_idx][entry.elem_idx];
      end = curr_max;
    }

    entry.elem_idx++;
    if (entry.elem_idx < a[entry.arr_idx].size()) {
      min_heap.push(entry);
      curr_max = max(curr_max, a[entry.arr_idx][entry.elem_idx]);
    } else {
      break;
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
      a[i] = std::move(v);
    }

    auto [start, end] = smallest_number_range(a, m);
    cout << start << " " << end << "\n";
  }

  return 0;
}