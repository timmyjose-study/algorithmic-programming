#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Interval {
  int start;
  int end;

  Interval(int start, int end) : start(start), end(end) {}
};

vector<Interval> merge(vector<Interval> &a) {
  if (a.size() < 2) {
    return a;
  }

  sort(a.begin(), a.end(), [](auto &a, auto &b) { return a.start <= b.start; });

  int start = a[0].start, end = a[0].end;
  vector<Interval> res;

  for (int i = 1; i < a.size(); i++) {
    if (a[i].start <= end) {
      end = max(end, a[i].end);
    } else {
      res.emplace_back(Interval(start, end));
      start = a[i].start;
      end = a[i].end;
    }
  }

  res.emplace_back(Interval(start, end));

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

    auto res = merge(a);
    for (auto inter : res) {
      cout << inter.start << " " << inter.end << "\n";
    }
  }

  return 0;
}