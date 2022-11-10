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

struct MinComp {
  const vector<vector<int>> &a;

  MinComp(const vector<vector<int>> &a) : a(a) {}

  bool operator()(const Entry &e1, const Entry &e2) {
    return a[e1.arr_idx][e1.elem_idx] > a[e2.arr_idx][e2.elem_idx];
  }
};

// O(nlogk) / O(k)
vector<int> merge(const vector<vector<int>> &a, int k) {
  MinComp comp(a);
  priority_queue<Entry, vector<Entry>, MinComp> min_heap(comp);

  for (int i = 0; i < k; i++) {
    min_heap.push(Entry(i, 0));
  }

  vector<int> res;
  while (!min_heap.empty()) {
    auto entry = min_heap.top();
    min_heap.pop();

    res.push_back(a[entry.arr_idx][entry.elem_idx]);
    entry.elem_idx++;

    if (entry.elem_idx < a[entry.arr_idx].size()) {
      min_heap.push(entry);
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
      a[i] = std::move(v);
    }

    auto res = merge(a, k);
    for (auto r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}