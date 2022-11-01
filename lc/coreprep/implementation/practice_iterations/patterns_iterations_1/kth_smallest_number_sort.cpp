#include <algorithm>
#include <iostream>
#include <random>
#include <vector>

using namespace std;

int get_random_number_in_closed_range(int low, int high) {
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

      if (j != i) {
        swap(a, j, i);
      }
    }
  }

  if (j != low) {
    swap(a, j, low);
  }

  return j;
}

void sort(vector<int> &a, int low, int high) {
  if (low >= high) {
    return;
  }

  int r = get_random_number_in_closed_range(low, high);
  swap(a, low, r);

  int mid = partition(a, low, high);
  sort(a, low, mid - 1);
  sort(a, mid + 1, high);
}

void sort(vector<int> &a) { sort(a, 0, a.size() - 1); }

// O(n2) / O(n)
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