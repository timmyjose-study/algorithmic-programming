#include <algorithm>
#include <iostream>

using namespace std;

bool is_happy(int n) {
  auto digit_square_sum = [](int m) {
    int sum = 0;

    while (m) {
      sum += (m % 10) * (m % 10);
      m /= 10;
    }

    return sum;
  };

  int fast = n, slow = n;

  do {
    fast = digit_square_sum(digit_square_sum(fast));
    slow = digit_square_sum(slow);
  } while (fast != slow);

  return slow == 1;
}

// O(logn) / O(1)
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