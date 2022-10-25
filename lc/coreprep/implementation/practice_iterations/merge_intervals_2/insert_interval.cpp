#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Interval {
  int start;
  int end;

  Interval(int start, int end) : start(start), end(end) {}
};

// O(n) / O(1)
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
      a.push_back(Interval(s, e));
    }

    cin >> s >> e;
    Interval new_interval(s, e);

    int i = 0;
    vector<Interval> res;
    while (i < n && a[i].end < new_interval.start) {
      res.push_back(a[i++]);
    }

    while (i < n && a[i].start <= new_interval.end) {
      new_interval.start = min(new_interval.start, a[i].start);
      new_interval.end = max(new_interval.end, a[i].end);
      i++;
    }

    res.push_back(new_interval);

    while (i < n) {
      res.push_back(a[i++]);
    }

    for (auto inter : res) {
      cout << inter.start << " " << inter.end << "\n";
    }
  }

  return 0;
}