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

// O(2n) / O(2n)
vector<vector<int>> subsets_with_duplicates(vector<int> &a) {
  sort(a.begin(), a.end());

  vector<vector<int>> res;
  res.push_back(vector<int>{});

  int prev = -1;
  for (int i = 0; i < a.size(); i++) {
    int size = res.size();
    int start = i > 0 && a[i] == a[i - 1] ? prev : 0;
    prev = res.size();

    for (int j = start; j < size; j++) {
      vector<int> sub(res[j]);
      sub.push_back(a[i]);
      res.push_back(sub);
    }
  }

  return res;
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

    auto res = subsets_with_duplicates(a);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}