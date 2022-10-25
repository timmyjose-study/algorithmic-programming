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

  // O(logn) / O(n)
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

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  string s;

  cin >> tt;
  while (tt--) {
    cin >> n;
    cin.ignore(numeric_limits<int>::max(), '\n');

    MedianOfStream mos;

    for (int i = 0; i < n; i++) {
      getline(cin, s);
      stringstream ss(s);
      string tmp;

      getline(ss, tmp, ' ');
      if (tmp == "insert") {
        getline(ss, tmp, ' ');
        mos.insert_elem(stoi(tmp));
      } else {
        cout << fixed << setprecision(1) << mos.find_median() << "\n";
      }
    }
  }

  return 0;
}