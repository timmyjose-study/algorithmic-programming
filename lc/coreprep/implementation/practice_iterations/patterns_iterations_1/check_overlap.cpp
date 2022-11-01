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

// O(nlogn) / O(1)
bool has_overlap(vector<Interval> &a) {
  sort(a.begin(), a.end(),
       [](auto &e1, auto &e2) { return e1.start <= e2.start; });

  int start = a[0].start;
  int end = a[0].end;

  for (int i = 1; i < a.size(); i++) {
    if (a[i].start <= end) {
      return true;
    } else {
      start = a[i].start;
      end = a[i].end;
    }
  }

  return false;
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

    cout << (has_overlap(a) ? "true" : "false") << "\n";
  }

  return 0;
}