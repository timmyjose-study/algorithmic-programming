#include <algorithm>
#include <cmath>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

struct Point {
  int x;
  int y;

  Point() : x(-1), y(-1) {}

  Point(int x, int y) : x(x), y(y) {}
};

double euclidean_distance(const Point &p) {
  return sqrt((double)p.x * p.x + (double)p.y * p.y);
}

struct CompPoint {
  const vector<Point> &a;

  CompPoint(const vector<Point> &a) : a(a) {}

  bool operator()(const Point &p1, const Point &p2) {
    return euclidean_distance(p1) < euclidean_distance(p2);
  }
};

// O(nlogk) / O(k)
vector<Point> k_closest_points_to_origin(const vector<Point> &a, int k) {
  CompPoint comp(a);
  priority_queue<Point, vector<Point>, CompPoint> max_heap(comp);

  for (int i = 0; i < k; i++) {
    max_heap.push(a[i]);
  }

  for (int i = k; i < a.size(); i++) {
    if (!max_heap.empty() &&
        euclidean_distance(a[i]) < euclidean_distance(max_heap.top())) {
      max_heap.pop();
      max_heap.push(a[i]);
    }
  }

  vector<Point> res;
  while (!max_heap.empty()) {
    res.push_back(max_heap.top());
    max_heap.pop();
  }

  return res;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k, x, y;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<Point> a(n);
    for (int i = 0; i < n; i++) {
      cin >> x >> y;
      a[i] = Point(x, y);
    }

    auto res = k_closest_points_to_origin(a, k);
    for (auto p : res) {
      cout << p.x << " " << p.y << "\n";
    }
  }

  return 0;
}