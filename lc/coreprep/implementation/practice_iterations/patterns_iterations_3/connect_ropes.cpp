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

// o(nlogn) / O(n)
int min_cost_to_connect(const vector<int> &a) {
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
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << min_cost_to_connect(a) << "\n";
  }

  return 0;
}