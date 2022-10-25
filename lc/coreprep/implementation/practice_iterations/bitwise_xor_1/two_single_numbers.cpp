#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

// O(n) / O(1)
pair<int, int> two_single_numbers(const vector<int> &a) {
  int x = 0;
  for (int e : a) {
    x ^= e;
  }

  int right_most_set_bit = 1;
  while (!(x & right_most_set_bit)) {
    right_most_set_bit <<= 1;
  }

  int num1 = 0, num2 = 0;
  for (int e : a) {
    if (e & right_most_set_bit) {
      num1 ^= e;
    } else {
      num2 ^= e;
    }
  }

  return make_pair(num1, num2);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto [num1, num2] = two_single_numbers(a);
    cout << num1 << " " << num2 << "\n";
  }

  return 0;
}