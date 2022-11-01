#include <algorithm>
#include <functional>
#include <iomanip>
#include <iostream>
#include <vector>

using namespace std;

template <typename T> class PriorityQueue {
private:
  vector<T> a;
  function<bool(T, T)> comp;

  int left(int p) { return 2 * p + 1; }
  int right(int p) { return 2 * p + 2; }
  int parent(int p) { return p / 2; }

  void swap(int x, int y) {
    T t = a[x];
    a[x] = a[y];
    a[y] = t;
  }

  void sift_up(int p) {
    while (p != 0 && this->comp(this->a[p], this->a[parent(p)])) {
      swap(p, parent(p));
      p = parent(p);
    }
  }

  void sift_down(int p) {
    int max_pos = p;

    int left_pos = left(p);
    if (left_pos < size() && this->comp(a[left_pos], a[max_pos])) {
      max_pos = left_pos;
    }

    int right_pos = right(p);
    if (right_pos < size() && this->comp(a[right_pos], a[max_pos])) {
      max_pos = right_pos;
    }

    if (max_pos != p) {
      swap(max_pos, p);
      sift_down(max_pos);
    }
  }

public:
  PriorityQueue(function<bool(T, T)> comp) : comp(std::move(comp)) {}

  int size() { return this->a.size(); }

  bool empty() { return size() == 0; }

  void push(T elem) {
    this->a.push_back(elem);
    sift_up(size() - 1);
  }

  T top() {
    if (empty()) {
      throw "empty priority queue";
    }

    return this->a[0];
  }

  void pop() {
    if (empty()) {
      throw "empty priority queue";
    }

    swap(0, size() - 1);
    this->a.pop_back();
    sift_down(0);
  }

  void remove_num(T elem) {
    if (empty()) {
      throw "empty priority queue";
    }

    for (int i = 0; i < size(); i++) {
      if (this->a[i] == elem) {
        this->a.erase(this->a.begin() + i);
        break;
      }
    }
  }
};

class MedianOfStream {
private:
  PriorityQueue<int> max_heap{{[](int a, int b) { return a > b; }}};
  PriorityQueue<int> min_heap{{[](int a, int b) { return a < b; }}};

  void rebalance() {
    if (max_heap.size() > min_heap.size() + 1) {
      min_heap.push(max_heap.top());
      max_heap.pop();
    } else if (max_heap.size() < min_heap.size()) {
      max_heap.push(min_heap.top());
      min_heap.pop();
    }
  }

public:
  MedianOfStream() {}

  // O(logn)
  void insert_num(int num) {
    if (max_heap.empty() || max_heap.top() >= num) {
      max_heap.push(num);
    } else {
      min_heap.push(num);
    }

    rebalance();
  }

  // O(n)
  void remove_num(int num) {
    if (max_heap.top() >= num) {
      max_heap.remove_num(num);
    } else {
      min_heap.remove_num(num);
    }

    rebalance();
  }

  // O(1)
  double find_median() {
    if (max_heap.size() == min_heap.size()) {
      return (double)(max_heap.top() + min_heap.top()) / 2.0;
    }
    return max_heap.top();
  }
};

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

    int window_start = 0;
    for (int window_end = 0; window_end < n; window_end++) {
      mos.insert_num(a[window_end]);

      if (window_end >= k - 1) {
        cout << fixed << setprecision(1) << mos.find_median() << " ";
        mos.remove_num(a[window_start]);
        window_start++;
      }
    }
    cout << "\n";
  }

  return 0;
}