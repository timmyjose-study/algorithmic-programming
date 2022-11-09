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
int bitonic_array_maximum(const vector<int> &a, int low, int high) {
  while (low < high) {
    int mid = low + (high - low) / 2;

    if (a[mid] > a[mid + 1]) {
      high = mid;
    } else {
      low = mid + 1;
    }
  }

  return a[low];
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

    cout << bitonic_array_maximum(a, 0, n - 1) << "\n";
  }

  return 0;
}