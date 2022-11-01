#include <algorithm>
#include <iostream>
#include <random>
#include <vector>

using namespace std;

int rand_in(int low, int high) {
  random_device rd;
  mt19937 engine(rd());
  uniform_int_distribution dist(low, high);

  return dist(engine);
}

void swap(vector<int> &a, int x, int y) {
  int t = a[x];
  a[x] = a[y];
  a[y] = t;
}

int partition(vector<int> &a, int low, int high) {
  int pivot = a[low];
  int j = low;

  for (int i = low + 1; i <= high; i++) {
    if (a[i] <= pivot) {
      j++;

      if (i != j) {
        swap(a, i, j);
      }
    }
  }

  if (low != j) {
    swap(a, low, j);
  }

  return j;
}

int quick_select(vector<int> &a, int low, int high, int k) {
  int r = rand_in(low, high);
  swap(a, low, r);

  int mid = partition(a, low, high);
  if (mid == k) {
    return a[mid];
  } else if (mid < k) {
    return quick_select(a, mid + 1, high, k);
  }
  return quick_select(a, low, mid - 1, k);
}

// O(n2) / O(n)
int kth_smallest_number(vector<int> &a, int k) {
  return quick_select(a, 0, a.size() - 1, k - 1);
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

    cout << kth_smallest_number(a, k) << "\n";
  }

  return 0;
}