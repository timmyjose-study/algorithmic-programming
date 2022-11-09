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
void sort(vector<int> &a) {
  int i = 0, low = 0, high = a.size() - 1;

  while (i <= high) {
    if (a[i] == 0) {
      swap(a, i, low);
      i++;
      low++;
    } else if (a[i] == 1) {
      i++;
    } else {
      swap(a, i, high);
      high--;
    }
  }
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

    sort(a);
    for (int e : a) {
      cout << e << " ";
    }
    cout << "\n";
  }

  return 0;
}