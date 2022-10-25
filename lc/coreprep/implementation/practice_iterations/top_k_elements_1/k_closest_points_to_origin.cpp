#include <algorithm>
#include <cmath>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct Point {
  int x;
  int y;

  Point(int x, int y) : x(x), y(y) {}
};

double dist_from_origin(const Point &p) {
  return sqrt((double)p.x * p.x + (double)p.y * p.y);
}

struct CompareDist {
  bool operator()(const Point &p1, const Point &p2) {
    return dist_from_origin(p1) < dist_from_origin(p2);
  }
};

// O(nlogk) / O(k)
vector<Point> k_closest_points_to_origin(const vector<Point> &a, int k) {
  priority_queue<Point, vector<Point>, CompareDist> max_heap;

  for (int i = 0; i < k; i++) {
    max_heap.push(a[i]);
  }

  for (int i = k; i < a.size(); i++) {
    if (dist_from_origin(a[i]) < dist_from_origin(max_heap.top())) {
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
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k, x, y;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<Point> a;
    for (int i = 0; i < n; i++) {
      cin >> x >> y;
      a.emplace_back(Point(x, y));
    }

    auto res = k_closest_points_to_origin(a, k);
    for (auto p : res) {
      cout << p.x << " " << p.y << "\n";
    }
  }

  return 0;
}