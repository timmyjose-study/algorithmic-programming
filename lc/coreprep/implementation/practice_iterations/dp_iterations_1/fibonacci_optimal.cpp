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

// O(n) / o(1)
long fibonacci(int n) {
  if (n < 2) {
    return n;
  }

  long a = 0, b = 1, c = 1;
  for (int i = 2; i < n; i++) {
    c = a + b;
    a = b;
    b = c;
  }

  return a + b;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << fibonacci(n) << "\n";
  }

  return 0;
}