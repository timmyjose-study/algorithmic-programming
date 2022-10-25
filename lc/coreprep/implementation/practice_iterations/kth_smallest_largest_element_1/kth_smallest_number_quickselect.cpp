#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <iostream>
#include <vector>

using namespace std;

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

// O(n2) / O(n)
int kth_smallest(vector<int> &a, int low, int high, int k) {
  int r = rand() % (high - low + 1) + low;
  swap(a, low, r);

  int mid = partition(a, low, high);
  if (mid == k) {
    return a[mid];
  } else if (mid < k) {
    return kth_smallest(a, mid + 1, high, k);
  }
  return kth_smallest(a, low, mid - 1, k);
}

int main() {
  srand(time(0));

  ios::sync_with_stdio(0);
  cin.tie(0);

  int tt, n, k;
  cin >> tt;

  while (tt--) {
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }

    cout << kth_smallest(a, 0, n - 1, k - 1) << "\n";
  }

  return 0;
}