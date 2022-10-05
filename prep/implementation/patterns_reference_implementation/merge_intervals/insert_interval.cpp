#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Interval {
  int start;
  int end;

  Interval(int start, int end) : start(start), end(end) {}
};

vector<Interval> insert(vector<Interval> &a, Interval &inter) {
  vector<Interval> res;

  int i = 0;
  while (i < a.size() && a[i].end < inter.start) {
    res.emplace_back(Interval(a[i].start, a[i].end));
    i++;
  }

  while (i < a.size() && a[i].start <= inter.end) {
    inter.start = min(inter.start, a[i].start);
    inter.end = max(inter.end, a[i].end);
    i++;
  }

  res.emplace_back(inter);

  while (i < a.size()) {
    res.emplace_back(a[i++]);
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

    cin >> s >> e;
    Interval inter(s, e);

    auto res = insert(a, inter);
    for (auto e : res) {
      cout << e.start << " " << e.end << "\n";
    }
  }

  return 0;
}