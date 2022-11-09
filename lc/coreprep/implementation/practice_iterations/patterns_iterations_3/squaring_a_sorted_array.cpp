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

// O(n) / O(n)
vector<int> square_sorted_array(const vector<int> &a) {
  int n = a.size();
  vector<int> res(n);
  int next_pos = n - 1;

  int left = 0, right = n - 1;
  while (left < right) {
    int left_sqr = a[left] * a[left];
    int right_sqr = a[right] * a[right];

    if (left_sqr < right_sqr) {
      res[next_pos--] = right_sqr;
      right--;
    } else {
      res[next_pos--] = left_sqr;
      left++;
    }
  }

  return res;
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

    auto res = square_sorted_array(a);
    for (int r : res) {
      cout << r << " ";
    }
    cout << "\n";
  }

  return 0;
}