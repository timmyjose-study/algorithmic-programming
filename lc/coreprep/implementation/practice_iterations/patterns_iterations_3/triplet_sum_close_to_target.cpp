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

// O(n2) / O(1)
int sum_of_closest_triplet_to_target(vector<int> &a, int s) {
  sort(a.begin(), a.end());

  int min_diff = numeric_limits<int>::max();
  for (int i = 0; i < a.size() - 1; i++) {
    int left = i + 1, right = a.size() - 1;
    while (left < right) {
      int diff = s - a[i] - a[left] - a[right];

      if (diff == 0) {
        return 0;
      }

      if (abs(diff) < abs(min_diff) ||
          (abs(diff) == abs(min_diff) && diff > min_diff)) {
        min_diff = diff;
      }

      if (diff > 0) {
        left++;
      } else {
        right--;
      }
    }
  }

  return s - min_diff;
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

    cout << sum_of_closest_triplet_to_target(a, s) << "\n";
  }

  return 0;
}