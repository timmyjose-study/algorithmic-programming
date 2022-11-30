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

// O(3n) / O(n)
int num_ways(int n) {
  if (n == 0) {
    return 1;
  }

  if (n == 1) {
    return 1;
  }

  if (n == 2) {
    return 2;
  }

  return num_ways(n - 1) + num_ways(n - 2) + num_ways(n - 3);
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