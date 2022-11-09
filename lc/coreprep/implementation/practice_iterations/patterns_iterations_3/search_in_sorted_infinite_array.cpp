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

class ArrayReader {
private:
  vector<int> a;

public:
  ArrayReader(vector<int> a) : a(std::move(a)) {}

  int get(int idx) {
    if (idx >= a.size()) {
      return numeric_limits<int>::max();
    }
    return a[idx];
  }
};

// O(logn) / O(1)
int binary_search(ArrayReader &arr, int k) {
  int low = 0;
  int high = 1;

  while (arr.get(high) < k) {
    low = high;
    high <<= 1;
  }

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (arr.get(mid) < k) {
      low = mid + 1;
    } else if (arr.get(mid) > k) {
      high = mid - 1;
    } else {
      return mid;
    }
  }

  return -1;
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

    ArrayReader arr(a);
    cout << binary_search(arr, k) << "\n";
  }

  return 0;
}