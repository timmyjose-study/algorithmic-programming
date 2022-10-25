#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void display(const vector<int> &a) {
  for (int e : a) {
    cout << e << " ";
  }
  cout << "\n";
}

void merge(vector<int> &a, int low, int mid, int high) {
  if (low > mid || mid >= high) {
    return;
  }

  int llen = mid - low + 1;
  vector<int> left(llen);
  for (int i = 0; i < llen; i++) {
    left[i] = a[low + i];
  }

  int rlen = high - mid;
  vector<int> right(rlen);
  for (int i = 0; i < rlen; i++) {
    right[i] = a[mid + i + 1];
  }

  int lpos = 0, rpos = 0;
  for (int i = low; i <= high; i++) {
    if (lpos < llen && rpos < rlen) {
      if (left[lpos] <= right[rpos]) {
        a[i] = left[lpos++];
      } else {
        a[i] = right[rpos++];
      }
    } else if (lpos < llen) {
      a[i] = left[lpos++];
    } else {
      a[i] = right[rpos++];
    }
  }
}

void sort(vector<int> &a, int low, int high) {
  if (low >= high) {
    return;
  }

  int mid = low + (high - low) / 2;
  sort(a, low, mid);
  sort(a, mid + 1, high);
  merge(a, low, mid, high);
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
  sort(a, 0, n - 1);
  display(a);

  return 0;
}