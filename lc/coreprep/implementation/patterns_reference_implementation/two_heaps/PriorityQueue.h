#ifndef _PRIORITY_QUEUE_
#define _PRIORITY_QUEUE_ "PriorityQueue.h"

#include <functional>
#include <vector>

template <typename T> class PriorityQueue {
private:
  std::vector<T> arr;
  std::function<bool(T, T)> comp;

  void swap(int x, int y) {
    T t = this->arr[x];
    this->arr[x] = this->arr[y];
    this->arr[y] = t;
  }

  int parent(int p) { return p / 2; }
  int left(int p) { return 2 * p + 1; }
  int right(int p) { return 2 * p + 2; }

  void sift_up(int p) {
    while (comp(this->arr[p], this->arr[parent(p)])) {
      swap(p, parent(p));
      p = parent(p);
    }
  }

  void sift_down(int p) {
    int max_idx = p;

    int left_idx = left(p);
    if (left_idx < size() && comp(this->arr[left_idx], this->arr[max_idx])) {
      max_idx = left_idx;
    }

    int right_idx = right(p);
    if (right_idx < size() && comp(this->arr[right_idx], this->arr[max_idx])) {
      max_idx = right_idx;
    }

    if (max_idx != p) {
      swap(max_idx, p);
      sift_down(max_idx);
    }
  }

public:
  PriorityQueue(std::function<bool(T, T)> comp) : comp(comp) {}

  bool empty() { return this->arr.empty(); }

  int size() { return this->arr.size(); }

  // O(logn)
  void add(T elem) {
    this->arr.push_back(elem);
    sift_up(size() - 1);
  }

  // O(1)
  T peek() {
    if (empty()) {
      throw "empty priority queue";
    }

    return this->arr[0];
  }

  // O(logn)
  T poll() {
    if (empty()) {
      throw "empty priority queue";
    }

    T val = this->arr[0];
    swap(0, size() - 1);
    this->arr.pop_back();
    sift_down(0);

    return val;
  }

  // O(n)
  void remove(T elem) {
    int elem_pos = -1;
    for (int i = 0; i < size(); i++) {
      if (this->arr[i] == elem) {
        elem_pos = i;
        break;
      }
    }

    if (elem_pos != -1) {
      swap(elem_pos, size() - 1);
      this->arr.pop_back();
      sift_down(elem_pos);
    }
  }
};

#endif