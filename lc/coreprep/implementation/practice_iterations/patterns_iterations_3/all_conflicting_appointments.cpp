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

// O(n2) / O(1)
vector<pair<Interval, Interval>>
all_conflicting_appointments(const vector<Interval> &a) {
  vector<pair<Interval, Interval>> res;

  auto has_conflict = [](auto &a, auto &b) {
    return (a.start >= b.start && a.start < b.end) ||
           (b.start >= a.start && b.start < a.end);
  };

  for (int i = 0; i < a.size() - 1; i++) {
    for (int j = i + 1; j < a.size(); j++) {
      if (has_conflict(a[i], a[j])) {
        res.push_back(make_pair<>(a[i], a[j]));
      }
    }
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, start, end;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<Interval> a(n);
    for (int i = 0; i < n; i++) {
      cin >> start >> end;
      a[i] = Interval(start, end);
    }

    auto res = all_conflicting_appointments(a);
    cout << res.size() << "\n";
    for (auto r : res) {
      cout << r.first.start << " " << r.first.end << " " << r.second.start
           << " " << r.second.end << "\n";
    }
  }

  return 0;
}