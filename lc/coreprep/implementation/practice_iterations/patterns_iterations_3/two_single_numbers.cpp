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
pair<int, int> two_single_numbers(const vector<int> &a) {
  int xor12 = 0;
  for (int e : a) {
    xor12 ^= e;
  }

  int first_set_bit_pos = 0;
  while (!(xor12 & (1 << first_set_bit_pos))) {
    first_set_bit_pos++;
  }

  int num1 = 0, num2 = 0;
  for (int e : a) {
    if (e & (1 << first_set_bit_pos)) {
      num1 ^= e;
    } else {
      num2 ^= e;
    }
  }

  return make_pair<>(num1, num2);
}

int main() {
  ios_base::sync_with_stdio(0);
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