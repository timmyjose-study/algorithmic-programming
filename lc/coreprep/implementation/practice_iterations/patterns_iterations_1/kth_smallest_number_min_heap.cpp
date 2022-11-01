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

// O(nlogn) / O(n)
int kth_smallest_number(const vector<int> &a, int k) {
  priority_queue<int, vector<int>, greater<int>> min_heap;

  for (int e : a) {
    min_heap.push(e);
  }

  while (k > 1) {
    min_heap.pop();
    k--;
  }

  return min_heap.top();
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << kth_smallest_number(a, k) << "\n";
  }

  return 0;
}