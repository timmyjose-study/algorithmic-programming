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

int max_profit(const vector<int> &a, bool own_share, int curr_idx) {
  if (curr_idx >= a.size()) {
    return 0;
  }

  if (own_share) {
    int sell = a[curr_idx] + max_profit(a, !own_share, curr_idx + 1);
    int not_sell = max_profit(a, own_share, curr_idx + 1);

    return max(sell, not_sell);
  }

  int buy = -a[curr_idx] + max_profit(a, !own_share, curr_idx + 1);
  int not_buy = max_profit(a, own_share, curr_idx + 1);

  return max(buy, not_buy);
}

int max_profit(const vector<int> &a) {
  if (a.empty()) {
    return 0;
  }

  return max_profit(a, false, 0);
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

    cout << max_profit(a) << "\n";
  }

  return 0;
}