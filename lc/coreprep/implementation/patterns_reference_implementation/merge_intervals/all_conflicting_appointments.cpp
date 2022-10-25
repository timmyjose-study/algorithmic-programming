#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Interval {
  int start;
  int end;

  Interval(int start, int end) : start(start), end(end) {}
};

vector<pair<Interval, Interval>> all_conflicts(const vector<Interval> &a) {
  const auto has_conflict = [](const Interval &a, const Interval &b) {
    return (a.start >= b.start && a.start < b.end) ||
           (b.start >= a.start && b.start < a.end);
  };

  vector<pair<Interval, Interval>> res;
  for (int i = 0; i < a.size(); i++) {
    for (int j = i + 1; j < a.size(); j++) {
      if (has_conflict(a[i], a[j])) {
        res.emplace_back(make_pair(a[i], a[j]));
      }
    }
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<Interval> a;
    int s, e;
    for (int i = 0; i < n; i++) {
      cin >> s >> e;
      a.emplace_back(Interval(s, e));
    }

    auto res = all_conflicts(a);
    cout << res.size() << "\n";
    for (auto r : res) {
      cout << r.first.start << " " << r.first.end << " " << r.second.start
           << " " << r.second.end << "\n";
    }
  }

  return 0;
}