#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct CompareDiff {
  const vector<int> &a;
  int x;

  CompareDiff(const vector<int> &a, int x) : a(a), x(x) {}

  bool operator()(int p, int q) const { return abs(a[p] - x) < abs(a[q] - x); }
};

int binary_search(const vector<int> &a, int low, int high, int elem) {
  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (a[mid] == elem) {
      return mid;
    } else if (a[mid] < elem) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }

  if (low > 0) {
    low--;
  }

  return low;
}

// O(logn + klogk) / O(k)
vector<int> k_closest_numbers(const vector<int> &a, int k, int x) {
  int xpos = binary_search(a, 0, a.size() - 1, x);
  int low = max(0, xpos - k);
  int high = min(xpos + k, (int)a.size() - 1);

  CompareDiff comp(a, x);
  priority_queue<int, vector<int>, CompareDiff> min_heap(comp);
  for (int i = xpos; i > low; i--) {
    min_heap.push(i);
  }

  for (int i = xpos + 1; i < high; i++) {
    min_heap.push(i);

    if (min_heap.size() > k) {
      min_heap.pop();
    }
  }

  vector<int> res;
  while (!min_heap.empty()) {
    res.push_back(a[min_heap.top()]);
    min_heap.pop();
  }

  sort(res.begin(), res.end());

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k, x;
  cin >> tt;

  while (tt--) {
    cin >> n >> k >> x;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = k_closest_numbers(a, k, x);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}