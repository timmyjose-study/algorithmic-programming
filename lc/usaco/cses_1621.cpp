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

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int n, val;
  unordered_set<int> s;

  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> val;
    s.insert(val);
  }

  cout << s.size() << "\n";

  return 0;
}