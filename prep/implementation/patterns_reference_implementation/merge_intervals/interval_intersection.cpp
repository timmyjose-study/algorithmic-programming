#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Interval {
  int start;
  int end;

  Interval(int start, int end) : start(start), end(end) {}
};

vector<Interval> intersect(const vector<Interval> &a,
                           const vector<Interval> &b) {
  vector<Interval> res;

  int i = 0, j = 0;
  while (i < a.size() && j < b.size()) {
    if ((a[i].start >= b[j].start && a[i].start <= b[j].end) ||
        (b[j].start >= a[i].start && b[j].start <= a[i].end)) {
      res.emplace_back(
          Interval(max(a[i].start, b[j].start), min(a[i].end, b[j].end)));
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
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, m;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<Interval> a, b;
    int s, e;

    for (int i = 0; i < n; i++) {
      cin >> s >> e;
      a.emplace_back(Interval(s, e));
    }

    cin >> m;
    for (int i = 0; i < m; i++) {
      cin >> s >> e;
      b.emplace_back(Interval(s, e));
    }

    auto res = intersect(a, b);
    for (auto r : res) {
      cout << r.start << " " << r.end << "\n";
    }
  }

  return 0;
}