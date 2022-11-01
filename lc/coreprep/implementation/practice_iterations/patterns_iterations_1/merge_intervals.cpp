#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Interval {
  int start;
  int end;

  Interval(int start, int end) : start(start), end(end) {}
};

// O(nlogn) / O(1)
vector<Interval> merge_intervals(vector<Interval> &a) {
  sort(a.begin(), a.end(),
       [](auto &e1, auto &e2) { return e1.start <= e2.start; });
  vector<Interval> res;
  int start = a[0].start;
  int end = a[0].end;

  for (int i = 1; i < a.size(); i++) {
    if (a[i].start <= end) {
      end = max(end, a[i].end);
    } else {
      res.push_back(Interval(start, end));
      start = a[i].start;
      end = a[i].end;
    }
  }

  res.push_back(Interval(start, end));

  return res;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, start, end;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<Interval> a;
    for (int i = 0; i < n; i++) {
      cin >> start >> end;
      a.push_back(Interval(start, end));
    }

    auto res = merge_intervals(a);
    for (auto r : res) {
      cout << r.start << " " << r.end << "\n";
    }
  }

  return 0;
}