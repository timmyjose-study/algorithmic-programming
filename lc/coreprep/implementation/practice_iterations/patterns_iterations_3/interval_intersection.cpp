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

struct Interval {
  int start;
  int end;

  Interval() : start(-1), end(-1) {}

  Interval(int start, int end) : start(start), end(end) {}
};

// O(n + m) / O(1)
vector<Interval> intersection(const vector<Interval> &a,
                              const vector<Interval> &b) {
  vector<Interval> res;

  auto has_overlap = [](auto a, auto b) {
    return (a.start >= b.start && a.start <= b.end) ||
           (b.start >= a.start && b.start <= a.end);
  };

  int i = 0, j = 0;
  while (i < a.size() && j < b.size()) {
    if (has_overlap(a[i], b[j])) {
      int start = max(a[i].start, b[j].start);
      int end = min(a[i].end, b[j].end);
      res.push_back(Interval(start, end));
    }

    if (a[i].end < b[j].end) {
      i++;
    } else {
      j++;
    }
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, m, start, end;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<Interval> a(n);
    for (int i = 0; i < n; i++) {
      cin >> start >> end;
      a[i] = Interval(start, end);
    }

    cin >> m;
    vector<Interval> b(m);
    for (int i = 0; i < m; i++) {
      cin >> start >> end;
      b[i] = Interval(start, end);
    }

    auto res = intersection(a, b);
    for (auto r : res) {
      cout << r.start << " " << r.end << "\n";
    }
  }

  return 0;
}