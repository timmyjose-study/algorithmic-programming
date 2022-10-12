#include "PriorityQueue.h"
#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  PriorityQueue<int> min_heap([=](int x, int y) { return x < y; });
  PriorityQueue<int> max_heap([=](int x, int y) { return x > y; });

  int n, e, m;
  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> e;
    min_heap.add(e);
    max_heap.add(e);
  }

  cin >> m;
  for (int i = 0; i < m; i++) {
    cin >> e;
    min_heap.remove(e);
    max_heap.remove(e);
  }

  while (!min_heap.empty()) {
    cout << min_heap.poll() << " ";
  }
  cout << "\n";

  while (!max_heap.empty()) {
    cout << max_heap.poll() << " ";
  }
  cout << "\n";

  return 0;
}