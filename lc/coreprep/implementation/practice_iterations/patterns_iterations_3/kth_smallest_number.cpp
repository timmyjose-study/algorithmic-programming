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

// O(nlogk) / O(k)
int kth_smallest_number(const vector<int> &a, int k) {
  priority_queue<int> max_heap;

  for (int i = 0; i < k; i++) {
    max_heap.push(a[i]);
  }

  for (int i = k; i < a.size(); i++) {
    if (a[i] < max_heap.top()) {
      max_heap.pop();
      max_heap.push(a[i]);
    }
  }

  return max_heap.top();
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