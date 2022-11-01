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

struct CompClosest {
  int x;

  CompClosest(int x) : x(x) {}

  bool operator()(int a, int b) { return abs(x - a) < abs(x - b); }
};

int binary_search(const vector<int> &a, int low, int high, int x) {
  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] < x) {
      low = mid + 1;
    } else if (a[mid] > x) {
      high = mid - 1;
    } else {
      return mid;
    }
  }

  if (low > 0) {
    low--;
  }

  return low;
}

// O(logn + klogk) / O(k)
vector<int> k_closest(const vector<int> &a, int k, int x) {
  CompClosest comp(x);
  priority_queue<int, vector<int>, CompClosest> max_heap(comp);

  int xpos = binary_search(a, 0, a.size() - 1, x);
  int start_pos = max(0, xpos - k);
  int end_pos = min(xpos + k, (int)a.size() - 1);

  for (int i = start_pos; i < end_pos; i++) {
    max_heap.push(a[i]);

    if (max_heap.size() > k) {
      max_heap.pop();
    }
  }

  for (int i = end_pos; i < a.size(); i++) {
    if (!max_heap.empty() && abs(x - a[i]) < abs(x - max_heap.top())) {
      max_heap.pop();
      max_heap.push(a[i]);
    }
  }

  vector<int> res;
  while (!max_heap.empty()) {
    res.push_back(max_heap.top());
    max_heap.pop();
  }

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
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}