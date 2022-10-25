#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Interval {
  int start;
  int end;

  Interval(int start, int end) : start(start), end(end) {}
};

bool check_overlap(vector<Interval> &a) {
  if (a.size() < 2) {
    return false;
  }

  sort(a.begin(), a.end(), [](auto &a, auto &b) { return a.start <= b.start; });

  for (int i = 1; i < a.size(); i++) {
    if (a[i].start <= a[i - 1].end) {
      return true;
    }
  }

  return false;
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

    cout << (check_overlap(a) ? "true" : "false") << "\n";
  }

  return 0;
}