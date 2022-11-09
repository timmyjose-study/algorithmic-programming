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

// O(n x n!) / O(n x n!)
vector<list<int>> permutations(const vector<int> &a) {
  vector<list<int>> res;

  queue<list<int>> q;
  q.push(list<int>{});

  for (int e : a) {
    int size = q.size();

    for (int i = 0; i < size; i++) {
      auto prev = q.front();
      q.pop();

      int len = prev.size();
      for (int j = 0; j <= len; j++) {
        list<int> curr(prev);

        auto it = curr.begin();
        advance(it, j);
        curr.insert(it, e);

        if (curr.size() == a.size()) {
          res.push_back(curr);
        } else {
          q.push(curr);
        }
      }
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

    auto res = permutations(a);
    for (auto r : res) {
      for (int e : r) {
        cout << e << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}