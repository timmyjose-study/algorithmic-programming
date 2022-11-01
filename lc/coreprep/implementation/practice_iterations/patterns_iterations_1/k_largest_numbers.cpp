#include <algorithm>
#include <iostream>
#include <queue>
#include <string>
#include <vector>

using namespace std;

// O(nlogk) / O(k)
vector<int> k_largest_numbers(const vector<int> &a, int k) {
  priority_queue<int, vector<int>, greater<int>> min_heap;

  for (int i = 0; i < k; i++) {
    min_heap.push(a[i]);
  }

  for (int i = k; i < a.size(); i++) {
    if (!min_heap.empty() && a[i] > min_heap.top()) {
      min_heap.pop();
      min_heap.push(a[i]);
    }
  }

  vector<int> res;
  while (!min_heap.empty()) {
    res.push_back(min_heap.top());
    min_heap.pop();
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = k_largest_numbers(a, k);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}