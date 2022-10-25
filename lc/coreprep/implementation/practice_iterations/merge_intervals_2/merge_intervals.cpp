#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Interval {
  int start;
  int end;

  Interval(int start, int end) : start(start), end(end) {}
};

// O(nlogn) / O(n)
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

    sort(a.begin(), a.end(),
         [](auto &a, auto &b) { return a.start <= b.start; });

    vector<Interval> res;
    int start = a[0].start;
    int end = a[0].end;

    for (int i = 1; i < n; i++) {
      if (a[i].start <= end) {
        end = max(end, a[i].end);
      } else {
        res.push_back(Interval(start, end));
        start = a[i].start;
        end = a[i].end;
      }
    }

    res.push_back(Interval(start, end));

    for (auto inter : res) {
      cout << inter.start << " " << inter.end << "\n";
    }
  }

  return 0;
}