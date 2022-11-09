#include <algorithm>
#include <functional>
#include <iomanip>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

template <typename T> class PriorityQueue {
private:
  vector<int> a;
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
    while (p >= 0 && comp(a[p], a[parent(p)])) {
      swap(p, parent(p));
      p = parent(p);
    }
  }

  void sift_down(int p) {
    int max_pos = p;

    int left_pos = left(p);
    if (left_pos < size() && comp(a[left_pos], a[max_pos])) {
      max_pos = left_pos;
    }

    int right_pos = right(p);
    if (right_pos < size() && comp(a[right_pos], a[max_pos])) {
      max_pos = right_pos;
    }

    if (max_pos != p) {
      swap(p, max_pos);
      sift_down(max_pos);
    }
  }

public:
  PriorityQueue(function<bool(T, T)> comp) : comp(comp) {}

  void push(T elem) {
    this->a.push_back(elem);
    sift_up(size() - 1);
  }

  T top() { return this->a[0]; }

  void pop() {
    swap(0, size() - 1);
    this->a.pop_back();
    sift_down(0);
  }

  bool empty() { return this->a.empty(); }

  int size() { return this->a.size(); }

  void remove(T elem) {
    for (auto it = this->a.begin(); it != this->a.end(); it++) {
      if (*it == elem) {
        this->a.erase(it);
        break;
      }
    }
  }
};

class MedianOfStream {
private:
  PriorityQueue<int> max_heap;
  PriorityQueue<int> min_heap;

  void rebalance() {
    if (max_heap.size() > min_heap.size() + 1) {
      min_heap.push(max_heap.top());
      max_heap.pop();
    } else if (min_heap.size() > max_heap.size()) {
      max_heap.push(min_heap.top());
      min_heap.pop();
    }
  }

public:
  MedianOfStream()
      : max_heap([](auto x, auto y) { return x > y; }),
        min_heap([](auto x, auto y) { return x < y; }) {}

  // O(logn) / O(n)
  void insert_num(int num) {
    if (max_heap.empty() || num < max_heap.top()) {
      max_heap.push(num);
    } else {
      min_heap.push(num);
    }

    rebalance();
  }

  // O(1) / O(1)
  double find_median() {
    if (max_heap.size() == min_heap.size()) {
      return (double)(max_heap.top() + min_heap.top()) / 2.0;
    }

    return max_heap.top();
  }

  // O(n) / O(1)
  void remove_num(int num) {
    if (num <= max_heap.top()) {
      max_heap.remove(num);
    } else {
      min_heap.remove(num);
    }

    rebalance();
  }
};

// O(n2) / O(n)
vector<double> sliding_window_median(const vector<int> &a, int k) {
  vector<double> res(a.size() - k + 1);

  MedianOfStream mos;
  int window_start = 0;

  for (int window_end = 0; window_end < a.size(); window_end++) {
    mos.insert_num(a[window_end]);

    if (window_end >= k - 1) {
      res[window_start] = mos.find_median();
      mos.remove_num(a[window_start]);
      window_start++;
    }
  }

  return res;
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

    auto res = sliding_window_median(a, k);
    for (double r : res) {
      cout << fixed << setprecision(1) << r << " ";
    }
    cout << "\n";
  }

  return 0;
}