#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

// O(nlogn) / O(n)
int connect_ropes(const vector<int> &a) {
  priority_queue<int, vector<int>, greater<int>> min_heap;

  for (int e : a) {
    min_heap.push(e);
  }

  int cost = 0;
  while (min_heap.size() > 1) {
    int f = min_heap.top();
    min_heap.pop();
    int s = min_heap.top();
    min_heap.pop();

    cost += f + s;
    min_heap.push(f + s);
  }

  return cost;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << connect_ropes(a) << "\n";
  }

  return 0;
}