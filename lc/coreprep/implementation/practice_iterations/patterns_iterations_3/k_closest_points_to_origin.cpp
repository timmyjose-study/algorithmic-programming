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

struct Point {
  int x;
  int y;

  Point() : x(0), y(0) {}
  Point(int x, int y) : x(x), y(y) {}
};

double dist(const Point &p) { return sqrt(p.x * p.x + p.y * p.y); }

struct PointComp {
  bool operator()(const Point &p1, const Point &p2) {
    return dist(p1) < dist(p2);
  }
};

// O(nlogk) / O(k)
vector<Point> k_closest_points_to_origin(const vector<Point> &a, int k) {
  priority_queue<Point, vector<Point>, PointComp> max_heap;

  for (int i = 0; i < k; i++) {
    max_heap.push(a[i]);
  }

  for (int i = k; i < a.size(); i++) {
    if (dist(a[i]) < dist(max_heap.top())) {
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
    for (auto r : res) {
      cout << r.x << " " << r.y << "\n";
    }
  }

  return 0;
}