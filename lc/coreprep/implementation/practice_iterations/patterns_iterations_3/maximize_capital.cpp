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

struct MinCap {
  const vector<int> &capital;

  MinCap(const vector<int> &capital) : capital(capital) {}

  bool operator()(int c1, int c2) { return capital[c1] > capital[c2]; }
};

struct MaxProfit {
  const vector<int> &profits;

  MaxProfit(const vector<int> &profits) : profits(profits) {}

  bool operator()(int p1, int p2) { return profits[p1] < profits[p2]; }
};

// O(nlogn + klogn) / O(k)
int maximize_capital(const vector<int> &capital, const vector<int> &profits,
                     int k, int c) {
  MinCap cap_comp(capital);
  priority_queue<int, vector<int>, MinCap> min_cap_heap(cap_comp);

  for (int i = 0; i < capital.size(); i++) {
    min_cap_heap.push(i);
  }

  MaxProfit profit_comp(profits);
  priority_queue<int, vector<int>, MaxProfit> max_profit_heap(profit_comp);

  int total_capital = c;
  for (int i = 0; i < k; i++) {
    while (!min_cap_heap.empty() &&
           total_capital >= capital[min_cap_heap.top()]) {
      max_profit_heap.push(min_cap_heap.top());
      min_cap_heap.pop();
    }

    if (max_profit_heap.empty()) {
      break;
    }

    total_capital += profits[max_profit_heap.top()];
    max_profit_heap.pop();
  }

  return total_capital;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, k, c, n;
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

    cout << maximize_capital(capital, profits, k, c) << "\n";
  }

  return 0;
}