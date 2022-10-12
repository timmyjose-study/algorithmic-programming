#include "PriorityQueue.h"
#include <algorithm>
#include <iomanip>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

// O(nlogn + klogn) / O(n)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, k, c, n;
  cin >> tt;

  while (tt--) {
    cin >> k >> c;
    cin >> n;

    vector<int> capital(n), profit(n);
    for (int i = 0; i < n; i++) {
      cin >> capital[i];
    }

    for (int i = 0; i < n; i++) {
      cin >> profit[i];
    }

    PriorityQueue<int> min_capital_heap(
        [&](int x, int y) { return capital[x] < capital[y]; });
    PriorityQueue<int> max_profit_heap(
        [&](int x, int y) { return profit[x] > profit[y]; });

    for (int i = 0; i < n; i++) {
      min_capital_heap.add(i);
    }

    int tot_cap = c;
    for (int i = 0; i < k; i++) {
      while (!min_capital_heap.empty() &&
             capital[min_capital_heap.peek()] <= tot_cap) {
        max_profit_heap.add(min_capital_heap.poll());
      }

      if (max_profit_heap.empty()) {
        break;
      }

      tot_cap += profit[max_profit_heap.poll()];
    }

    cout << tot_cap << "\n";
  }

  return 0;
}