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

int binary_search(const vector<int> &a, int low, int high, int k) {
  if (k < a[low]) {
    return low;
  }

  if (k > a[high]) {
    return high;
  }

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] < k) {
      low = mid + 1;
    } else if (a[mid] > k) {
      high = mid - 1;
    } else {
      return mid;
    }
  }

  return abs(k - a[low]) < abs(k - a[high]) ? low : high;
}

struct CloseComp {
  const vector<int> &a;
  int x;

  CloseComp(const vector<int> &a, int x) : a(a), x(x) {}

  bool operator()(int p, int q) { return abs(x - a[p]) < abs(x - a[q]); }
};

// O(logn + klogk) / O(k)
vector<int> k_closest(const vector<int> &a, int k, int x) {
  int pos = binary_search(a, 0, a.size() - 1, x);
  int start = max(0, (int)pos - k);
  int end = min(pos + k, (int)a.size() - 1);

  CloseComp comp(a, x);
  priority_queue<int, vector<int>, CloseComp> max_heap(comp);

  for (int i = start; i <= end; i++) {
    if (max_heap.size() < k) {
      max_heap.push(i);
    } else if (abs(x - a[i]) < abs(x - a[max_heap.top()])) {
      max_heap.pop();
      max_heap.push(i);
    }
  }

  vector<int> res;
  while (!max_heap.empty()) {
    res.push_back(a[max_heap.top()]);
    max_heap.pop();
  }

  sort(res.begin(), res.end());

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k, x;
  cin >> tt;

  while (tt--) {
    cin >> n >> k >> x;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = k_closest(a, k, x);
    for (auto r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}