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

// O(N2) / O(1)
int count_triplets_with_smaller_sum(vector<int> &a, int s) {
  sort(a.begin(), a.end());

  int cnt = 0;
  for (int i = 0; i < a.size() - 2; i++) {
    int left = i + 1, right = a.size() - 1;

    while (left < right) {
      int sum = a[i] + a[left] + a[right];

      if (sum < s) {
        cnt += right - left;
        left++;
        right--;
      } else {
        left++;
      }
    }
  }

  return cnt;
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

    cout << count_triplets_with_smaller_sum(a, s) << "\n";
  }

  return 0;
}