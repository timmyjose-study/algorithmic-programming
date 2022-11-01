#include <algorithm>
#include <cmath>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

// O(nlogn) / O(n)
int sum_of_elements(const vector<int> &a, int k1, int k2) {
  priority_queue<int, vector<int>, greater<int>> min_heap;

  for (int e : a) {
    min_heap.push(e);
  }

  for (int i = 0; i < k1; i++) {
    min_heap.pop();
  }

  int sum = 0;
  for (int i = 0; i < k2 - k1 - 1; i++) {
    sum += min_heap.top();
    min_heap.pop();
  }

  return sum;
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