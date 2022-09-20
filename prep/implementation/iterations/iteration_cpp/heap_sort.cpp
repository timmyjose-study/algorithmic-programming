#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void display(const vector<int> &a) {
  for (int e : a) {
    cout << e << " ";
  }
  cout << "\n";
}

int left(int p) { return 2 * p + 1; }

int right(int p) { return 2 * p + 2; }

void swap(vector<int> &a, int x, int y) {
  int t = a[x];
  a[x] = a[y];
  a[y] = t;
}

void sift_down(vector<int> &a, int i, int n) {
  int max_idx = i;

  int left_idx = left(i);
  if (left_idx < n && a[left_idx] > a[max_idx]) {
    max_idx = left_idx;
  }

  int right_idx = right(i);
  if (right_idx < n && a[right_idx] > a[max_idx]) {
    max_idx = right_idx;
  }

  if (max_idx != i) {
    swap(a, max_idx, i);
    sift_down(a, max_idx, n);
  }
}

void build_heap(vector<int> &a, int n) {
  for (int i = n / 2; i >= 0; i--) {
    sift_down(a, i, n);
  }
}

void sort(vector<int> &a, int n) {
  build_heap(a, n);

  int len = n;
  for (int i = 0; i < n - 1; i++) {
    swap(a, 0, len - 1);
    len--;
    sift_down(a, 0, len);
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }

  display(a);
  sort(a, n);
  display(a);

  return 0;
}