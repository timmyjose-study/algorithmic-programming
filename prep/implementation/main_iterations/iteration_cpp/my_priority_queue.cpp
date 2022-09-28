#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

template <typename T> class priority_queue {
private:
  vector<T> arr;

  int parent(int p) { return p / 2; }

  int left(int p) { return 2 * p + 1; }

  int right(int p) { return 2 * p + 2; }

  void swap(int p, int q) {
    T t = this->arr[p];
    this->arr[p] = this->arr[q];
    this->arr[q] = t;
  }

  void sift_up(int p) {
    while (p != 0 && (this->arr[parent(p)] < this->arr[p])) {
      swap(p, parent(p));
      p = parent(p);
    }
  }

  void sift_down(int p) {
    int len = this->arr.size();

    int max_idx = p;

    int left_idx = left(p);
    if (left_idx<len &&this->arr[left_idx]> this->arr[max_idx]) {
      max_idx = left_idx;
    }

    int right_idx = right(p);
    if (right_idx < len && (this->arr[right_idx] > this->arr[max_idx])) {
      max_idx = right_idx;
    }

    if (max_idx != p) {
      swap(max_idx, p);
      sift_down(max_idx);
    }
  }

public:
  void add(T elem) {
    this->arr.push_back(elem);
    sift_up(this->arr.size() - 1);
  }

  bool empty() { return this->arr.empty(); }

  T poll() {
    if (empty()) {
      throw "empty priority queue";
    }

    swap(0, this->arr.size() - 1);
    T val = this->arr.back();
    this->arr.pop_back();
    sift_down(0);

    return val;
  }
};

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, d;
  cin >> n;

  priority_queue<int> max_heap;
  for (int i = 0; i < n; i++) {
    cin >> d;
    max_heap.add(d);
  }

  cout << max_heap.empty() << "\n";

  while (!max_heap.empty()) {
    cout << max_heap.poll() << " ";
  }
  cout << "\n";

  cout << max_heap.empty() << "\n";

  return 0;
}