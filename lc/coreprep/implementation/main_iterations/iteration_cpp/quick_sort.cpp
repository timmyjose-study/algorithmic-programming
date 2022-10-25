#include <algorithm>
#include <cmath>
#include <iostream>
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

int random_number(int low, int high) { return rand() % (high - low) + low; }

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

void sort(vector<int> &a, int low, int high) {
  if (low >= high) {
    return;
  }

  int r = random_number(low, high);
  swap(a, low, r);

  int mid = partition(a, low, high);
  sort(a, low, mid - 1);
  sort(a, mid + 1, high);
}

int main() {
  srand(time(0));
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  display(a);
  sort(a, 0, n - 1);
  display(a);

  return 0;
}