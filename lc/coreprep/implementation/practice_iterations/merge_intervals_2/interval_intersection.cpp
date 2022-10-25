#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Interval {
  int start;
  int end;

  Interval(int start, int end) : start(start), end(end) {}
};

bool has_overlap(const Interval &a, const Interval &b) {
  return (a.start >= b.start && a.start <= b.end) ||
         (b.start >= a.start && b.start <= a.end);
}

// O(n + m) / O(1)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, m;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<Interval> a;
    int s, e;
    for (int i = 0; i < n; i++) {
      cin >> s >> e;
      a.push_back(Interval(s, e));
    }

    cin >> m;
    vector<Interval> b;
    for (int i = 0; i < m; i++) {
      cin >> s >> e;
      b.push_back(Interval(s, e));
    }

    vector<Interval> res;

    int i = 0, j = 0;
    while (i < n && j < m) {
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

    for (auto inter : res) {
      cout << inter.start << " " << inter.end << "\n";
    }
  }

  return 0;
}