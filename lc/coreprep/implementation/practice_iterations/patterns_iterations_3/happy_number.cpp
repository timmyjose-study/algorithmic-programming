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

// O(logn) / O(1)
bool is_happy(int n) {
  auto sum_sqr_digits = [](int m) {
    int s = 0;
    while (m) {
      s += (m % 10) * (m % 10);
      m /= 10;
    }
    return s;
  };

  int slow = n, fast = n;
  do {
    slow = sum_sqr_digits(slow);
    fast = sum_sqr_digits(sum_sqr_digits(fast));
  } while (slow != fast);

  return slow == 1;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << (is_happy(n) ? "true" : "false") << "\n";
  }

  return 0;
}