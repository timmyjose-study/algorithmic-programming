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

struct KthLargestInStream {
  priority_queue<int, vector<int>, greater<int>> min_heap;

  // O(nlogk) / O(k)
  KthLargestInStream(vector<int> &a, int k) {
    for (int i = 0; i < k; i++) {
      min_heap.push(a[i]);
    }

    for (int i = k; i < a.size(); i++) {
      if (!min_heap.empty() && a[i] > a[min_heap.top()]) {
        min_heap.pop();
        min_heap.push(a[i]);
      }
    }
  }

  // O(logk) / O(k)
  int add(int num) {
    if (min_heap.empty()) {
      throw "empty heap";
    }

    if (num > min_heap.top()) {
      min_heap.pop();
      min_heap.push(num);
    }

    return min_heap.top();
  }
};

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

    KthLargestInStream stream(a, k);

    int nq, num;
    cin >> nq;

    while (nq--) {
      cin >> num;
      cout << stream.add(num) << "\n";
    }
  }

  return 0;
}