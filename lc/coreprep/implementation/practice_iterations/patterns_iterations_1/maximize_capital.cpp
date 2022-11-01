#include <algorithm>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

struct CapitalComp {
  const vector<int> &capital;

  CapitalComp(const vector<int> &capital) : capital(capital) {}

  bool operator()(int c1, int c2) { return capital[c1] > capital[c2]; }
};

struct ProfitComp {
  const vector<int> &profits;

  ProfitComp(const vector<int> &profits) : profits(profits) {}

  bool operator()(int p1, int p2) { return profits[p1] < profits[p2]; }
};

// O(clogc + plogc) / O(c)
int maximum_capital(const vector<int> &capital, const vector<int> &profits,
                    int k, int c) {
  CapitalComp cap_comp(capital);
  priority_queue<int, vector<int>, CapitalComp> min_cap_heap(cap_comp);

  ProfitComp profit_comp(profits);
  priority_queue<int, vector<int>, ProfitComp> max_profit_heap(profit_comp);

  for (int i = 0; i < capital.size(); i++) {
    min_cap_heap.push(i);
  }

  int tot_cap = c;
  for (int i = 0; i < k; i++) {
    while (!min_cap_heap.empty() && capital[min_cap_heap.top()] <= tot_cap) {
      max_profit_heap.push(min_cap_heap.top());
      min_cap_heap.pop();
    }

    if (max_profit_heap.empty()) {
      break;
    }

    tot_cap += profits[max_profit_heap.top()];
    max_profit_heap.pop();
  }

  return tot_cap;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k, c;
  cin >> tt;

  while (tt--) {
    cin >> k >> c >> n;

    vector<int> capital(n);
    for (int i = 0; i < n; i++) {
      cin >> capital[i];
    }

    vector<int> profits(n);
    for (int i = 0; i < n; i++) {
      cin >> profits[i];
    }

    cout << maximum_capital(capital, profits, k, c) << "\n";
  }

  return 0;
}