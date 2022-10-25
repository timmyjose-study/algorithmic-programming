#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

int random_number(int low, int high) { return rand() % (high - low + 1) + low; }

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
  int r = random_number(low, high);
  swap(a, low, r);

  int mid = partition(a, low, high);

  if (mid == k) {
    return a[mid];
  } else if (mid < k) {
    return quick_select(a, mid + 1, high, k);
  }
  return quick_select(a, low, mid - 1, k);
}

int main() {
  srand(time(0));
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, nq, k;
  cin >> n >> nq;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  while (nq--) {
    cin >> k;
    cout << quick_select(a, 0, n - 1, k) << "\n";
  }

  return 0;
}