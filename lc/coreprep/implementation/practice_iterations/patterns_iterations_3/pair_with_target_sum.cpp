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
pair<int, int> pair_with_target_sum(const vector<int> &a, int s) {
  int left = 0, right = a.size() - 1;

  while (left < right) {
    int sum = a[left] + a[right];

    if (sum == s) {
      return make_pair<>(left, right);
    }

    if (sum < s) {
      left++;
    } else {
      right--;
    }
  }

  return make_pair<>(-1, -1);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, s;
  cin >> tt;

  while (tt--) {
    cin >> n >> s;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    auto [pos1, pos2] = pair_with_target_sum(a, s);
    cout << pos1 << " " << pos2 << "\n";
  }

  return 0;
}