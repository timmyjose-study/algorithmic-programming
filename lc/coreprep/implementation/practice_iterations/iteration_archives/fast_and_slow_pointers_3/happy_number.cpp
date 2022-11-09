#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool is_happy(int n) {
  auto digit_sum_square = [](int m) {
    int sum = 0;

    while (m) {
      sum += (m % 10) * (m % 10);
      m /= 10;
    }
    return sum;
  };

  int fast = n, slow = n;
  do {
    fast = digit_sum_square(digit_sum_square(fast));
    slow = digit_sum_square(slow);

  } while (fast != slow);

  return slow == 1;
}

// O(logn)/ O(1)
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;
    cout << (is_happy(n) ? "true" : "false") << "\n";
  }

  return 0;
}