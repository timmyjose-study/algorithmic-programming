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

struct Entry {
  string s;
  int nl;
  int nr;

  Entry(string s, int nl, int nr) : s(s), nl(nl), nr(nr) {}
};

// O(n x 2n) / O(n x 2n!)
vector<string> balance_parentheses(int n) {
  vector<string> res;

  queue<Entry> q;
  q.push(Entry("(", 1, 0));

  while (!q.empty()) {
    int size = q.size();

    int newly_added_to_queue = 0;
    for (int i = 0; i < size; i++) {
      auto prev = q.front();
      q.pop();

      if (prev.nl < n) {
        q.push(Entry(prev.s + "(", prev.nl + 1, prev.nr));
        newly_added_to_queue++;
      }

      if (prev.nr < prev.nl) {
        q.push(Entry(prev.s + ")", prev.nl, prev.nr + 1));
        newly_added_to_queue++;
      }

      if (newly_added_to_queue == 0) {
        res.push_back(prev.s);
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

    auto res = balance_parentheses(n);
    for (auto r : res) {
      cout << r << "\n";
    }
  }

  return 0;
}