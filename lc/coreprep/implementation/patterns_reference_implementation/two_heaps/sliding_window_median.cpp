#include "PriorityQueue.h"
#include <algorithm>
#include <iomanip>
#include <iostream>
#include <limits>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class MedianOfStream {
private:
  PriorityQueue<int> max_heap;
  PriorityQueue<int> min_heap;

  void rebalance() {
    if (max_heap.size() > min_heap.size() + 1) {
      min_heap.add(max_heap.poll());
    } else if (max_heap.size() < min_heap.size()) {
      max_heap.add(min_heap.poll());
    }
  }

public:
  MedianOfStream()
      : max_heap([](int x, int y) { return x > y; }),
        min_heap([](int x, int y) { return x < y; }) {}

  // O(logn)
  void insert_elem(int n) {
    if (max_heap.empty() || max_heap.peek() >= n) {
      max_heap.add(n);
    } else {
      min_heap.add(n);
    }

    rebalance();
  }

  // O(1)
  double find_median() {
    if (max_heap.size() == min_heap.size()) {
      return (max_heap.peek() + min_heap.peek()) / 2.0;
    }
    return max_heap.peek();
  }

  // O(n)
  void remove_elem(int n) {
    if (max_heap.peek() >= n) {
      max_heap.remove(n);
    } else {
      min_heap.remove(n);
    }

    rebalance();
  }
};

// O(nk) / O(k)
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

    MedianOfStream mos;

    vector<double> res(n - k + 1);
    int window_start = 0;
    for (int window_end = 0; window_end < n; window_end++) {
      mos.insert_elem(a[window_end]);

      if (window_end >= k - 1) {
        res[window_start] = mos.find_median();
        mos.remove_elem(a[window_start]);
        window_start++;
      }
    }

    for (double d : res) {
      cout << fixed << setprecision(1) << d << " ";
    }
    cout << "\n";
  }

  return 0;
}