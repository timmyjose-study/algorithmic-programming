#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Interval {
  int start;
  int end;

  Interval() : start(-1), end(-1) {}

  Interval(int start, int end) : start(start), end(end) {}
};

// O(n) / O(1)
vector<Interval> insert_interval(vector<Interval> &a, Interval &new_interval) {
  vector<Interval> res;

  int i = 0;
  while (i < a.size() && new_interval.start > a[i].end) {
    res.push_back(a[i]);
    i++;
  }

  while (i < a.size() && a[i].start <= new_interval.end) {
    new_interval.start = min(new_interval.start, a[i].start);
    new_interval.end = max(new_interval.end, a[i].end);
    i++;
  }

  res.push_back(new_interval);

  while (i < a.size()) {
    res.push_back(a[i]);
    i++;
  }

  return res;
}

int main() {
  ios::sync_with_stdio(0);
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

    cin >> start >> end;
    Interval new_interval(start, end);

    auto res = insert_interval(a, new_interval);
    for (auto r : res) {
      cout << r.start << " " << r.end << "\n";
    }
  }

  return 0;
}