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

void swap(vector<int> &a, int x, int y) {
  int t = a[x];
  a[x] = a[y];
  a[y] = t;
}

// O(n) / O(1)
int missing_number(vector<int> &a) {
  int i = 0;
  while (i < a.size()) {
    if (a[i] < a.size() && (a[i] != a[a[i]])) {
      swap(a, i, a[i]);
    } else {
      i++;
    }
  }

  for (int i = 0; i < a.size(); i++) {
    if (i != a[i]) {
      return i;
    }
  }
  return -1;
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n;
  cin >> tt;

  while (tt--) {
    cin >> n;

    vector<int> a(n - 1);
    for (int i = 0; i < n - 1; i++) {
      cin >> a[i];
    }

    cout << missing_number(a) << "\n";
  }

  return 0;
}