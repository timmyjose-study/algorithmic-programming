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

// O(n3) / O(n2)
vector<vector<int>>
subarrays_with_product_less_than_target(const vector<int> &a, int s) {
  vector<vector<int>> res;
  int product = 1, window_start = 0;

  for (int window_end = 0; window_end < a.size(); window_end++) {
    product *= a[window_end];

    while (product >= s) {
      product /= a[window_start];
      window_start++;
    }

    deque<int> q;
    for (int i = window_end; i >= window_start; i--) {
      q.push_front(a[i]);

      vector<int> v(q.begin(), q.end());
      res.push_back(v);
    }
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, s;
  cin >> tt;

  while (tt--) {
    cin >> n >> s;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto res = subarrays_with_product_less_than_target(a, s);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}