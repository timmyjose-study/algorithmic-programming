#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int knapsack(vector<pair<int, int>> const &a, int curr_idx, int currv,
             int currw, int w) {
  if (currw > w) {
    return currv;
  }

  if (curr_idx >= a.size()) {
    return currv;
  }

  auto [c, v] = a[curr_idx];
  int choose = 0, dont_choose = 0;
  if (currw + c <= w) {
    choose = knapsack(a, curr_idx + 1, currv + v, currw + c, w);
  }
  dont_choose = knapsack(a, curr_idx + 1, currv, currw, w);

  return max(choose, dont_choose);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, w;
  cin >> n >> w;

  vector<pair<int, int>> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i].first;
    cin >> a[i].second;
  }

  cout << knapsack(a, 0, 0, 0, w) << "\n";

  return 0;
}