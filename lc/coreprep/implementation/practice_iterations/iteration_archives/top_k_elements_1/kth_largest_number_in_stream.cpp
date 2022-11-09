#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class KthLargestInStream {
private:
  priority_queue<int, vector<int>, greater<int>> min_heap;

public:
  KthLargestInStream(vector<int> a, int k) {
    for (int i = 0; i < k; i++) {
      min_heap.push(a[i]);
    }

    for (int i = k; i < a.size(); i++) {
      if (a[i] > min_heap.top()) {
        min_heap.pop();
        min_heap.push(a[i]);
      }
    }
  }

  // O(logk) / O(k)
  int add(int num) {
    if (num > min_heap.top()) {
      min_heap.pop();
      min_heap.push(num);
    }

    return min_heap.top();
  }
};

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k, nq, num;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    KthLargestInStream stream(a, k);

    cin >> nq;
    while (nq--) {
      cin >> num;
      cout << stream.add(num) << "\n";
    }
  }

  return 0;
}