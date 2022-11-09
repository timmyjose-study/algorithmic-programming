#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Interval {
  int start;
  int end;

  Interval(int start, int end) : start(start), end(end) {}
};

bool has_conflict(const Interval &a, const Interval &b) {
  return (a.start >= b.start && a.start < b.end) ||
         (b.start >= a.start && b.start < a.end);
}

// O(n2) / O(1)
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

    vector<vector<Interval>> res;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (has_conflict(a[i], a[j])) {
          vector<Interval> v;
          v.push_back(a[i]);
          v.push_back(a[j]);
          res.emplace_back(v);
        }
      }
    }

    cout << res.size() << "\n";
    for (auto cs : res) {
      cout << cs[0].start << " " << cs[0].end << " " << cs[1].start << " "
           << cs[1].end << "\n";
    }
  }

  return 0;
}