#include <algorithm>
#include <cmath>
#include <iostream>
#include <limits>
#include <list>
#include <queue>
#include <random>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int next_random(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution<int> dist(low, high);

  return dist(engine);
}

struct Interval {
  int start;
  int end;

  Interval() : start(-1), end(-1) {}

  Interval(int start, int end) : start(start), end(end) {}
};

// O(nlogn) / O(1)
bool has_conflict(vector<Interval> &a) {
  sort(a.begin(), a.end(),
       [](auto &p1, auto &p2) { return p1.start < p2.start; });

  auto has_overlap = [](auto a, auto b) {
    return (a.start >= b.start && a.start < b.end) ||
           (b.start >= a.start && b.start < a.end);
  };

  for (int i = 0; i < a.size() - 1; i++) {
    if (has_overlap(a[i], a[i + 1])) {
      return true;
    }
  }

  return false;
}

int main() {
  ios_base::sync_with_stdio(0);
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

    cout << (has_conflict(a) ? "false" : "true") << "\n";
  }

  return 0;
}