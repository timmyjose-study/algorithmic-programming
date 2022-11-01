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

// O(nlogk2) / O(k2)
int sum_of_elements(const vector<int> &a, int k1, int k2) {
  priority_queue<int> max_heap;

  for (int i = 0; i < k2; i++) {
    max_heap.push(a[i]);
  }

  for (int i = k2; i < a.size(); i++) {
    if (!max_heap.empty() && a[i] < max_heap.top()) {
      max_heap.pop();
      max_heap.push(a[i]);
    }
  }

  max_heap.pop();

  int sum = 0;
  for (int i = 0; i < k2 - k1 - 1; i++) {
    sum += max_heap.top();
    max_heap.pop();
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