#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

struct MaxComp {
  const vector<int> &a;

  MaxComp(const vector<int> &a) : a(a) {}

  bool operator()(int p, int q) { return a[p] < a[q]; }
};

// O(nlogk2) / O(k2)
int sum_of_elements(const vector<int> &a, int k1, int k2) {
  MaxComp comp(a);
  priority_queue<int, vector<int>, MaxComp> max_heap(comp);

  for (int i = 0; i < k2 - 1; i++) {
    max_heap.push(i);
  }

  for (int i = k2 - 1; i < a.size(); i++) {
    if (a[i] < a[max_heap.top()]) {
      max_heap.pop();
      max_heap.push(i);
    }
  }

  int res = 0;
  for (int i = 0; i < k2 - k1 - 1; i++) {
    res += a[max_heap.top()];
    max_heap.pop();
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k1, k2;
  cin >> tt;

  while (tt--) {
    cin >> n >> k1 >> k2;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << sum_of_elements(a, k1, k2) << "\n";
  }

  return 0;
}