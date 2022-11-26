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

// O(n) / O(1)
int num_ways(int n) {
  int a = 1, b = 1, c = 2, d = 0;

  if (n == 0) {
    return a;
  }

  if (n == 1) {
    return b;
  }

  if (n == 2) {
    return c;
  }

  for (int i = 3; i < n; i++) {
    d = a + b + c;
    a = b;
    b = c;
    c = d;
  }

  return a + b + c;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << num_ways(n) << "\n";
  }

  return 0;
}