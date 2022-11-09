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

int partition(vector<int> &, int, int);

int median_of_medians(vector<int> &a, int low, int high) {
  int n = high - low + 1;

  if (n < 5) {
    return a[low];
  }

  int np = n / 5;
  vector<int> medians(np);
  for (int i = 0; i < np; i++) {
    int start = low + i * 5;
    sort(a.begin() + start, a.begin() + start + 5);
    medians[i] = a[start + 2];
  }

  return partition(medians, 0, np - 1);
}

int partition(vector<int> &a, int low, int high) {
  int median = median_of_medians(a, low, high);

  for (int i = low; i <= high; i++) {
    if (a[i] == median) {
      swap(a, i, low);
      break;
    }
  }

  int pivot = a[low];
  int j = low;

  for (int i = low + 1; i <= high; i++) {
    if (a[i] <= pivot) {
      j++;

      if (j != i) {
        swap(a, j, i);
      }
    }
  }

  if (low != j) {
    swap(a, low, j);
  }

  return j;
}

// O(nlogn) / O(n)
int quick_select(vector<int> &a, int low, int high, int k) {
  int mid = partition(a, low, high);

  if (mid == k) {
    return a[mid];
  } else if (mid < k) {
    return quick_select(a, mid + 1, high, k);
  }
  return quick_select(a, low, mid - 1, k);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, nq, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> nq;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    while (nq--) {
      cin >> k;
      cout << quick_select(a, 0, n - 1, k) << "\n";
    }
  }

  return 0;
}