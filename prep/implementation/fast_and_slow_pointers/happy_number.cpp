#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

bool is_happy(int n) {
  int fast = n, slow = n;

  auto find_square_sum = [](int n) {
    int sum = 0;

    while (n) {
      sum += (n % 10) * (n % 10);
      n /= 10;
    }
    return sum;
  };

  do {
    fast = find_square_sum(find_square_sum(fast));
    slow = find_square_sum(slow);
  } while (fast != slow);

  return slow == 1;
}

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