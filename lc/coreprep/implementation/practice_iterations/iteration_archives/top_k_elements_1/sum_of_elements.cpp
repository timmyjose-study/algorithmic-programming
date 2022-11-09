#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

// O(nlogn) / O(n)
int sum_between_k1_k2(const vector<int> &a, int k1, int k2) {
  priority_queue<int, vector<int>, greater<int>> min_heap;

  for (int e : a) {
    min_heap.push(e);
  }

  for (int i = 0; i < k1; i++) {
    min_heap.pop();
  }

  int res = 0;
  for (int i = 0; i < k2 - k1 - 1; i++) {
    res += min_heap.top();
    min_heap.pop();
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k1, k2;
  cin >> tt;

  while (tt--) {
    cin >> n >> k1 >> k2;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << sum_between_k1_k2(a, k1, k2) << "\n";
  }

  return 0;
}