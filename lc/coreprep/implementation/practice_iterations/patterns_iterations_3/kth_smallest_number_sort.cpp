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

// O(min + max) / O(1)
void sort(vector<int> &a) {
  int min_val = a[0], max_val = a[0];
  for (int i = 1; i < a.size(); i++) {
    min_val = min(min_val, a[i]);
    max_val = max(max_val, a[i]);
  }

  int k = max_val - min_val + 1;
  vector<int> b(k);
  for (int e : a) {
    b[e - min_val]++;
  }

  int idx = 0;
  for (int i = 0; i < k; i++) {
    int f = b[i];
    while (f--) {
      a[idx++] = i + min_val;
    }
  }
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

    sort(a);
    cout << a[k - 1] << "\n";
  }

  return 0;
}