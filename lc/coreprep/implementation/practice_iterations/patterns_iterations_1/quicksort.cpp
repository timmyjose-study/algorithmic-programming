#include <algorithm>
#include <cmath>
#include <iostream>
#include <list>
#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

void display(const vector<int> &a) {
  for (int e : a) {
    cout << e << " ";
  }
  cout << "\n";
}

void swap(vector<int> &a, int x, int y) {
  int t = a[x];
  a[x] = a[y];
  a[y] = t;
}

int partition(vector<int> &a, int low, int high);

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

void sort(vector<int> &a, int low, int high) {
  if (low >= high) {
    return;
  }

  int mid = partition(a, low, high);
  sort(a, low, mid - 1);
  sort(a, mid + 1, high);
}

// O0nlogn) / O(n)
void sort(vector<int> &a) { sort(a, 0, a.size() - 1); }

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

    display(a);
    sort(a);
    display(a);
  }

  return 0;
}