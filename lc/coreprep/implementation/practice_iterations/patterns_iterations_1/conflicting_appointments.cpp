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
bool can_attend_all(vector<Interval> &a) {
  sort(a.begin(), a.end(),
       [](const auto &e1, const auto &e2) { return e1.start <= e2.start; });

  auto has_overlap = [](const auto &e1, const auto &e2) {
    return (e1.start >= e2.start && e1.start < e2.end) ||
           (e2.start >= e1.start && e2.start < e1.end);
  };

  for (int i = 0; i < a.size() - 1; i++) {
    if (has_overlap(a[i], a[i + 1])) {
      return false;
    }
  }

  return true;
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

    cout << (can_attend_all(a) ? "true" : "false") << "\n";
  }

  return 0;
}