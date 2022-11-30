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
long fibonacci(long n) {
  long a = 0, b = 1, c = 1;

  if (n == 0) {
    return a;
  }

  if (n == 1) {
    return b;
  }

  for (int i = 2; i <= n; i++) {
    c = a + b;
    a = b;
    b = c;
  }
  return c;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt;
  long n;

  cin >> tt;
  while (tt--) {
    cin >> n;
    cout << fibonacci(n) << "\n";
  }

  return 0;
}