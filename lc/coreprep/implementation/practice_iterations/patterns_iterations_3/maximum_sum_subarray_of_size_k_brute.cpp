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

// O(nk) / O(1)
int maximum_sum_subarray_of_size_k(const vector<int> &a, int k) {
  int n = a.size();
  int max_sum = numeric_limits<int>::min();

  for (int i = 0; i < n - k + 1; i++) {
    int sum = 0;
    for (int j = i; j < i + k; j++) {
      sum += a[j];
    }

    max_sum = max(max_sum, sum);
  }

  return max_sum;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << maximum_sum_subarray_of_size_k(a, k) << "\n";
  }

  return 0;
}